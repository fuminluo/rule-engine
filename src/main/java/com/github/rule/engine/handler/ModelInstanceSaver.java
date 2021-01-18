package com.github.rule.engine.handler;

import com.github.rule.engine.dto.InstanceBuildContext;
import com.github.rule.engine.handler.ContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/5 16:48
 */
@Slf4j
@Component
public class ModelInstanceSaver  implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--保存模型实例到相关DB表--");
        // 假装保存模型实例
        return true;
    }
}
