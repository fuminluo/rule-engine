package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.mapper.ApplicationMapper;
import com.github.rule.engine.mapper.ApplicationTemplateMapper;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.service.AbstractExecuteService;
import com.github.rule.engine.service.ObjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (TObjectData)表服务实现类
 *
 * @author makejava
 * @since 2020-10-08 19:06:57
 */
@Service
public class ObjectDataServiceImpl extends ServiceImpl<ObjectDataMapper, ObjectData> implements ObjectDataService {

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationTemplateMapper applicationTemplateMapper;

    @Autowired
    ObjectDataMapper objectDataMapper;

    @Override
    public R execute(ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException {
        AbstractExecuteService defaultExecuteObjectData = new DefaultExecuteServiceImpl(executeRequest);
        R result = defaultExecuteObjectData.doExecute();
        return result;
    }
}