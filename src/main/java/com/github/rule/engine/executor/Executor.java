package com.github.rule.engine.executor;


import com.github.rule.engine.dto.LatchPipelineContext;
import com.github.rule.engine.dto.PipelineContext;
import com.github.rule.engine.handler.ContextHandler;

import java.util.List;
import java.util.function.Consumer;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/14 10:53
 */
public interface Executor {

    /**
     * 同步处理
     *
     * @param context 输入的上下文数据
     * @return 处理成功 true，失败 false
     */
    boolean acceptSync(PipelineContext context);

    boolean acceptConcurrentSync(LatchPipelineContext context, List<? extends ContextHandler<? super LatchPipelineContext>> contextHandlers) throws InterruptedException;

    /**
     * 函数同步处理
     *
     * @param context 输入的上下文数据
     * @param consumer  处理函数
     */
    boolean acceptSync(PipelineContext context, Consumer<? super PipelineContext> consumer);

    /**
     * 同步处理
     *
     * @param context         输入的上下文数据
     * @param contextHandlers 处理器
     * @return 处理成功 true，失败 false
     */
    boolean acceptSync(PipelineContext context, List<? extends ContextHandler<? super PipelineContext>> contextHandlers);

}
