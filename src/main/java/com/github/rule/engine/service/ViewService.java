package com.github.rule.engine.service;

import com.github.rule.engine.dto.ApiViewDTO;
import com.github.rule.engine.entity.View;
import java.util.List;

/**
 * 自定义视图(TView)表服务接口
 *
 * @author makejava
 * @since 2021-02-07 17:27:06
 */
public interface ViewService {
    Object findData(ApiViewDTO apiViewDTO) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}