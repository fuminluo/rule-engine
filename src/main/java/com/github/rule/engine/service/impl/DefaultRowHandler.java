package com.github.rule.engine.service.impl;

import com.github.rule.engine.service.CustomRowHandler;
import lombok.extern.log4j.Log4j2;

import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/8 9:48
 */
@Log4j2
public class DefaultRowHandler implements CustomRowHandler {

    public DefaultRowHandler() {
        log.info("## 创建 DefaultRowHandler ... ");
        // 预处理动作,1-载入缓存,2-其他
    }

    @Override
    public void customRowHandler(Map<String, Object> var1, String columnKey, Object columnValue) {
    }
}
