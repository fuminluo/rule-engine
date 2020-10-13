package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.enums.PutTypeEnum;
import com.github.rule.engine.service.AbstractExecuteObjectData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author admin
 * @DATE 2020/10/12 16:54
 */
@Slf4j
public class DefaultExecuteObjectData extends AbstractExecuteObjectData {

    protected List<ApplicationTemplate> applicationTemplates;

    public DefaultExecuteObjectData(ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException {
        super(executeRequest);
    }

    @Override
    public R<?> doExecute() throws NoSuchFieldException, IllegalAccessException {
        applicationTemplates = super.applicationTemplateList;
        if (CollectionUtils.isEmpty(applicationTemplates)) {
            return R.failed("应用模板为空");
        }
        String applicationId = applicationTemplates.get(0).getApplicationId().toUpperCase();

        StringBuilder sqlPart = new StringBuilder();
        for (ApplicationTemplate appTemplate : applicationTemplates) {
            if (PutTypeEnum.IN.getValue().equals(appTemplate.getInOut())
                    || PutTypeEnum.INOUT.getValue().equals(appTemplate.getInOut())
            ) {
                Field field = objectDataDTO.getClass().getDeclaredField(appTemplate.getFieldName());
                field.setAccessible(true);
                Object fieldValue = field.get(objectDataDTO);
                sqlPart.append(" and ");
                sqlPart.append(appTemplate.getColumnName()).append(" ");
                sqlPart.append(appTemplate.getArithmetic()).append(" ");
                sqlPart.append(fieldValue).append(" ");
            } else if (!StringUtils.isEmpty(appTemplate.getArithmetic())) {
                sqlPart.append(" and ");
                sqlPart.append(appTemplate.getColumnName()).append(" ");
                sqlPart.append(appTemplate.getArithmetic()).append(" ");
            }
        }
        ObjectData objectData = objectDataMapper.queryCustom(objectDataDTO.getHashCode(), applicationId, sqlPart.toString());
        Class objectDataClass = objectData.getClass();
        Map<String, Object> result = new HashMap<>(applicationTemplates.size());
        for (ApplicationTemplate appTemplate : applicationTemplates) {
            if (PutTypeEnum.OUT.getValue().equals(appTemplate.getInOut())
                    || PutTypeEnum.INOUT.getValue().equals(appTemplate.getInOut())) {
                Field field = objectDataClass.getDeclaredField(appTemplate.getFieldName());
                field.setAccessible(true);
                Object obj = field.get(objectData);
                result.put(appTemplate.getSegmentCode(), obj);
            }
        }
        return R.ok(result);
    }

}
