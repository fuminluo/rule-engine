package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.enums.PutTypeEnum;
import com.github.rule.engine.service.AbstractExecuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author admin
 * @DATE 2020/10/12 16:54
 */
@Slf4j
public class DefaultExecuteServiceImpl extends AbstractExecuteService {

    protected List<ApplicationTemplate> applicationTemplates;

    public DefaultExecuteServiceImpl(ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException {
        super(executeRequest);
    }

    @Override
    public R<?> doExecute() throws NoSuchFieldException, IllegalAccessException {
        applicationTemplates = super.applicationTemplateList;
        if (CollectionUtils.isEmpty(applicationTemplates)) {
            return R.failed("应用模板为空");
        }
        Map<String, Object> requestParam = executeRequest.getParam();
        StringBuilder sqlPart = new StringBuilder();
        for (ApplicationTemplate appTemplate : applicationTemplates) {
            if (PutTypeEnum.IN.getValue().equals(appTemplate.getInOut())
                    || PutTypeEnum.INOUT.getValue().equals(appTemplate.getInOut())
            ) {
                Object fieldValue = requestParam.get(appTemplate.getSegmentCode());
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
        ObjectData objectData = objectDataMapper.queryCustom(objectDataDTO.getHashCode(), objectDataDTO.getApplicationId(), sqlPart.toString());
        return R.ok(objectToResult(objectData));
    }

}
