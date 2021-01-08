package com.github.rule.engine.service.impl;

import com.github.rule.engine.dto.InstanceBuildContext;
import com.github.rule.engine.service.ContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/5 16:47
 */
@Slf4j
@Component
public class ModelInstanceCreator implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--根据输入数据创建模型实例--");
        // 假装创建模型实例
        context.setEndTime(LocalDateTime.now());
        return true;
    }
}
