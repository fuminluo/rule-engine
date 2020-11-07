package com.github.rule.engine.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.rule.engine.dto.LabelDTO;
import com.github.rule.engine.dto.ValueSetRequest;
import com.github.rule.engine.entity.ValueSet;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 值集表(TValueSet)表服务接口
 *
 * @author makejava
 * @since 2020-10-07 22:30:17
 */
public interface ValueSetService extends IService<ValueSet> {

    R<?> findvalueSet(ValueSetRequest valueSetRequest);

    R<?> importValueSet(MultipartFile file, String applicationId) throws Exception;

    void getExcelTemplate(String applicationId) throws IOException;

    R<?> getJavaField();

    R<?> getJavaType();

    R<?> getInOutType();

    List<LabelDTO> findSegmentLabel();

    List<LabelDTO> getColumnName();

    List<LabelDTO> getcolumnType();
}