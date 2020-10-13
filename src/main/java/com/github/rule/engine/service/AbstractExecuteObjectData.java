package com.github.rule.engine.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.dto.ObjectDataDTO;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.enums.PutTypeEnum;
import com.github.rule.engine.mapper.ApplicationTemplateMapper;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.utils.SpringContextUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @Author admin
 * @DATE 2020/10/12 14:38
 */
public abstract class AbstractExecuteObjectData {

    protected ObjectDataMapper objectDataMapper = SpringContextUtils.getBean(ObjectDataMapper.class);

    protected ApplicationTemplateMapper applicationTemplateMapper = SpringContextUtils.getBean(ApplicationTemplateMapper.class);

    protected List<ApplicationTemplate> applicationTemplateList;

    protected ObjectDataDTO objectDataDTO = new ObjectDataDTO();

    protected ExecuteRequest executeRequest;

    public AbstractExecuteObjectData(ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException {
        this.executeRequest = executeRequest;
        convertToEntity();
        initHashCode();
    }

    protected void convertToEntity() throws NoSuchFieldException, IllegalAccessException {
        Map<String, Object> requestParam = executeRequest.getParam();
        Class objClass = objectDataDTO.getClass();
        applicationTemplateList = applicationTemplateMapper.findListByApplicationCode(executeRequest.getApplicationCode());
        if (CollectionUtils.isEmpty(applicationTemplateList)) {
            return;
        }
        String applicationId = applicationTemplateList.get(0).getApplicationId();
        objectDataDTO.setApplicationId(applicationId);
        for (ApplicationTemplate apptemplate : applicationTemplateList) {
            if (PutTypeEnum.IN.getValue().equals(apptemplate.getInOut()) ||
                    PutTypeEnum.INOUT.getValue().equals(apptemplate.getInOut()) ||
                    StringUtils.isEmpty(apptemplate.getArithmetic())) {
                Object obj = requestParam.get(apptemplate.getSegmentCode());
                Field fieldName = objClass.getDeclaredField(apptemplate.getFieldName());
                fieldName.setAccessible(true);
                fieldName.set(objectDataDTO, obj);
            }
        }
    }

    /**
     * 实例化 hashCode
     */
    protected void initHashCode() {
        Long hashCode = objectDataMapper.queryHashCode(objectDataDTO);
        objectDataDTO.setHashCode(hashCode);
    }

    /**
     * 执行查询
     *
     * @return R
     */
    protected abstract R<?> doExecute() throws NoSuchFieldException, IllegalAccessException;

}
