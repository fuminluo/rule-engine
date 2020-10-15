package com.github.rule.engine.service.impl;

import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.service.IValidated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 重复数据校验
 *
 * @Author Admin
 * @DATE 2020/10/15 17:04
 */
@Service
public class RepeatDataValidatedImpl implements IValidated {

    @Autowired
    ObjectDataMapper objectDataMapper;

    @Override
    public void doValid(String applicationId, Long batchGroupId) {
        //查询重复hashCode
        List<Long> hashCodes = objectDataMapper.queryRepeatHashCode(applicationId, batchGroupId);

        List<ObjectData> objectDataList = objectDataMapper.queryRepeatObjectData(applicationId, batchGroupId, hashCodes);
    }
}
