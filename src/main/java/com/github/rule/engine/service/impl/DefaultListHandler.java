package com.github.rule.engine.service.impl;

import com.github.rule.engine.service.CustomListHandler;
import lombok.extern.log4j.Log4j2;

import java.util.List;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/18 17:46
 */
@Log4j2
public class DefaultListHandler<T> implements CustomListHandler<T> {

    public DefaultListHandler() {
        log.info("## 创建 DefaultListHandler ... ");
        // 预处理动作,1-载入缓存,2-其他
    }

    @Override
    public List<T> customListHandler(List<T> results) {
        return results;
    }
}
