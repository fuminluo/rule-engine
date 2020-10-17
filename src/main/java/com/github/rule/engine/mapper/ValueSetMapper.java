package com.github.rule.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.OptionDTO;
import com.github.rule.engine.dto.ValueSetExcelDTO;
import com.github.rule.engine.dto.ValueSetRequest;
import com.github.rule.engine.entity.ValueSet;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 值集表(TValueSet)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 22:30:15
 */
@Mapper
public interface ValueSetMapper extends BaseMapper<ValueSet> {


    List<OptionDTO> findvalueSet(ValueSetRequest valueSetRequest);

    int insertBatchTemp(@Param("list") List<ValueSetExcelDTO> list,
                    @Param("applicationId") String applicationId,
                    @Param("segmentCode") String segmentCode,
                    @Param("segmentName") String segmentName,
                    @Param("rootId") String rootId);

    int copyInsertBatch();
}