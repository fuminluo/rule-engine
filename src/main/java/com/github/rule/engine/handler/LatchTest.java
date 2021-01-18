package com.github.rule.engine.handler;

import com.github.rule.engine.dto.LatchPipelineContext;
import com.github.rule.engine.handler.ContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/11 19:07
 */
@Slf4j
@Component
public class LatchTest implements ContextHandler<LatchPipelineContext> {
    @Override
    public boolean handle(LatchPipelineContext context) {
        try {
            if (context.getIsContinue()) {
                log.info("--根据输入数据创建模型实例--" + Thread.currentThread().getId());
                context.setIsContinue(false);
            }
            return true;
        } catch (Exception e) {
            log.error(" e : {}", e);
            context.addErrorMsg(e.getMessage());
        } finally {
            log.info("--LatchTest--" + Thread.currentThread().getId());
            if (null != context.getLatch() && context.getLatch().getCount() > 0) {
                context.getLatch().countDown();
            }
        }
        return false;
    }
}
