package com.github.rule.engine.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.dto.InsertBatchObjectRequest;
import com.github.rule.engine.entity.ObjectData;

/**
 * (TObjectData)表服务接口
 *
 * @author makejava
 * @since 2020-10-08 19:06:57
 */
public interface ObjectDataService extends IService<ObjectData> {

    R execute(ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException;

    Integer insertBatch(InsertBatchObjectRequest insertBatchObjectRequest);

    R validated(String applicationId);
}