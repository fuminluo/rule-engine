package com.github.rule.engine.service.impl;

import com.github.rule.engine.dto.LatchPipelineContext;
import com.github.rule.engine.dto.PipelineContext;
import com.github.rule.engine.service.ContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

/**
 * 管道执行器
 *
 * @Author LuoFuMin
 * @DATE 2021/1/5 16:58
 */
@Slf4j
@Service
public class PipelineExecutor {

    /**
     * 管道线程池
     */
    @Resource
    private ThreadPoolTaskExecutor pipelineThreadPool;

    /**
     * 引用 PipelineRouteConfig 中的 pipelineRouteMap
     */
    @Resource
    private Map<Class<? extends PipelineContext>,
            List<? extends ContextHandler<? super PipelineContext>>> pipelineRouteMap;

    /**
     * 同步处理输入的上下文数据<br/>
     * 如果处理时上下文数据流通到最后一个处理器且最后一个处理器返回 true，则返回 true，否则返回 false
     *
     * @param context 输入的上下文数据
     * @return 处理过程中管道是否畅通，畅通返回 true，不畅通返回 false
     */
    public boolean acceptSync(PipelineContext context) throws InterruptedException {
        Objects.requireNonNull(context, "上下文数据不能为 null");
        // 拿到数据类型
        Class<? extends PipelineContext> dataType = context.getClass();
        // 获取数据处理管道
        List<? extends ContextHandler<? super PipelineContext>> pipeline = pipelineRouteMap.get(dataType);
        if (CollectionUtils.isEmpty(pipeline)) {
            log.error("{} 的管道为空", dataType.getSimpleName());
            return false;
        }
        // 管道是否畅通
        boolean lastSuccess = true;
        for (ContextHandler<? super PipelineContext> handler : pipeline) {
            try {
                // 当前处理器处理数据，并返回是否继续向下处理
                handler.handle(context);
            } catch (Throwable ex) {
                lastSuccess = false;
                log.error("[{}] 处理异常，handler={}", context.getName(), handler.getClass().getSimpleName(), ex);
            }
            // 不再向下处理
            if (!lastSuccess) {
                break;
            }
        }
        return lastSuccess;
    }

    /**
     * 同步处理输入的上下文数据<br/>
     * 如果处理时上下文数据流通到最后一个处理器且最后一个处理器返回 true，则返回 true，否则返回 false
     * extends上界(get)， 带有extends子类型限定的通配符可以向泛型对象读取,如果参数化类型表示一个生产者，就使用<? extends T>
     * super下界(add),带有super超类型限定的通配符可以向泛型对象中写入,如果它表示一个消费者，就使用<? super T>
     *
     * @param context 输入的上下文数据
     * @return 处理过程中管道是否畅通，畅通返回 true，不畅通返回 false
     */
    public boolean acceptSync(PipelineContext context, List<? extends ContextHandler<? super PipelineContext>> contextHandlers) {
        Objects.requireNonNull(context, "上下文数据不能为 null");
        // 获取数据处理管道
        if (CollectionUtils.isEmpty(contextHandlers)) {
            // 拿到数据类型
            Class<? extends PipelineContext> dataType = context.getClass();
            log.error("{} 的管道为空", dataType.getSimpleName());
            return false;
        }
        // 管道是否畅通
        boolean lastSuccess = true;
        for (ContextHandler<? super PipelineContext> handler : contextHandlers) {
            try {
                // 当前处理器处理数据，并返回是否继续向下处理
                lastSuccess = handler.handle(context);
            } catch (Throwable ex) {
                lastSuccess = false;
                log.error("[{}] 处理异常，handler={}", context.getName(), handler.getClass().getSimpleName(), ex);
            }
            // 不再向下处理
            if (!lastSuccess) {
                log.error("errorMsg : {}", context.getErrorMsg());
                break;
            }
        }
        return lastSuccess;
    }


    /**
     * 异步处理输入的上下文数据
     *
     * @param context  上下文数据
     * @param callback 处理完成的回调
     */
    public void acceptAsync2(PipelineContext context, BiConsumer<PipelineContext, Boolean> callback) {
        pipelineThreadPool.execute(() -> {
            boolean success = false;
            try {
                success = acceptSync(context);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (callback != null) {
                callback.accept(context, success);
            }
        });
    }

    /**
     * 异步处理输入的上下文数据
     *
     * @param context 上下文数据
     */
    public boolean acceptConcurrentSync(LatchPipelineContext context, List<? extends ContextHandler<? super LatchPipelineContext>> contextHandlers) throws InterruptedException {
        Objects.requireNonNull(context, "上下文数据不能为 null");
        CountDownLatch latch = new CountDownLatch(contextHandlers.size());
        context.setLatch(latch);
        // 管道是否畅通
        for (ContextHandler<? super LatchPipelineContext> handler : contextHandlers) {
            // 当前处理器处理数据，并返回是否继续向下处理
            pipelineThreadPool.execute(() -> {
                handler.handle(context);
            });
        }
        latch.await(context.getWaitTime(), TimeUnit.SECONDS);
        context.getErrorMsg();
        return true;
    }
}
