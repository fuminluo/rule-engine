package com.github.rule.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.rule.engine.dto.ObjectDataDTO;
import com.github.rule.engine.entity.ObjectData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * (TObjectData)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-08 19:06:56
 */
@Mapper
public interface ObjectDataMapper extends BaseMapper<ObjectData> {

    ObjectData findOne(ObjectDataDTO objectDataDTO);

    ObjectData queryAll(ObjectData objectData);

    ObjectData queryCustom(@Param("hashCode") Long hashCode, @Param("applicationId") String applicationId,
                           @Param("sqlPart") String sqlPart);

    Long queryHashCode(ObjectDataDTO objectDataDTO);

}