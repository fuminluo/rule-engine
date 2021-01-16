package com.github.rule.engine.service.impl;

import com.github.rule.engine.dto.LatchPipelineContext;
import com.github.rule.engine.service.ContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/11 19:07
 */
@Slf4j
@Component
public class LatchTest2 implements ContextHandler<LatchPipelineContext> {
    @Override
    public boolean handle(LatchPipelineContext context) {
        try {
            Thread.sleep(1000);
            if (context.getIsContinue()){
                log.info("--根据输入数据创建模型实例--" + Thread.currentThread().getId());
            }
            context.addErrorMsg("LatchTest2");
            return true;
        } catch (InterruptedException e) {
            log.error(" e : {}", e);
            context.addErrorMsg("LatchTest2");
        } finally {
            log.info("--LatchTest2--" + Thread.currentThread().getId());
            if (null != context.getLatch() && context.getLatch().getCount()>0){
                context.getLatch().countDown();
            }
        }
        return false;
    }
}
