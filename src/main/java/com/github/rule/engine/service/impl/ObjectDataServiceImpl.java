package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.dto.ObjectDataDTO;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.enums.PutTypeEnum;
import com.github.rule.engine.mapper.ApplicationMapper;
import com.github.rule.engine.mapper.ApplicationTemplateMapper;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.service.AbstractExecuteObjectData;
import com.github.rule.engine.service.ObjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        /*List<ApplicationTemplate> applicationTemplateList = applicationTemplateMapper.findListByApplicationCode(executeRequest.getApplicationCode());
        if (CollectionUtils.isEmpty(applicationTemplateList)) {
            return R.failed("未找到应用");
        }
        Map<String, String> inConfigMap = applicationTemplateList.stream().filter(var -> var.getInOut().equals(PutTypeEnum.IN.getValue())).collect(Collectors.toMap(ApplicationTemplate::getSegmentCode, ApplicationTemplate::getFieldName));
        ObjectDataDTO objectDataDTO = new ObjectDataDTO();
        Class objClass = objectDataDTO.getClass();
        Map<String, Object> requestParam = executeRequest.getParam();
        for (Map.Entry<String, String> entry : inConfigMap.entrySet()) {
            Object obj = requestParam.get(entry.getKey());
            Field field = objClass.getDeclaredField(entry.getValue());
            field.setAccessible(true);
            field.set(objectDataDTO, obj);
        }
        objectDataDTO.setApplicationId(applicationTemplateList.get(0).getApplicationId());
        ObjectData objectData = objectDataMapper.findOne(objectDataDTO);
        if (null == objectData) {
            return R.failed("未击中规则");
        }
        Map<String, String> outConfigMap = applicationTemplateList.stream().filter(var ->
                var.getInOut().equals(PutTypeEnum.OUT.getValue()) || var.getInOut().equals(PutTypeEnum.INOUT.getValue())
        ).collect(Collectors.toMap(ApplicationTemplate::getSegmentCode, ApplicationTemplate::getFieldName));

        Map<String, Object> result = new HashMap<>();
        Class objectDataClass = objectData.getClass();
        for (Map.Entry<String, String> entry : outConfigMap.entrySet()) {
            Field field = objectDataClass.getDeclaredField(entry.getValue());
            field.setAccessible(true);
            Object value = field.get(objectData);
            result.put(entry.getKey(), value);
        }*/
        DefaultExecuteObjectData defaultExecuteObjectData = new DefaultExecuteObjectData(executeRequest);
        R result = defaultExecuteObjectData.doExecute();
        return result;
    }
}