package com.github.rule.engine.service.impl;

import com.github.rule.engine.dto.InstanceBuildContext;
import com.github.rule.engine.service.ContextHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2021/1/5 16:45
 */
@Slf4j
@Component
public class InputDataPreChecker implements ContextHandler<InstanceBuildContext> {
    @Override
    public boolean handle(InstanceBuildContext context) {
        log.info("--输入数据校验--");
        Map<String, Object> formInput = context.getFormInput();

        if (MapUtils.isEmpty(formInput)) {
            context.setErrorMsg("表单输入数据不能为空");
            return false;
        }
        String instanceName = (String) formInput.get("instanceName");
        if (StringUtils.isBlank(instanceName)) {
            context.setErrorMsg("表单输入数据必须包含实例名称");
            return false;
        }
        return true;
    }
}
