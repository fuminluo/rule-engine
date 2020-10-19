package com.github.rule.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.rule.engine.dto.InsertBatchObjectRequest;
import com.github.rule.engine.dto.ObjectDataDTO;
import com.github.rule.engine.entity.ObjectData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    int insertColumnBatch(@Param("dataList") InsertBatchObjectRequest insertBatchObjectRequest);

    List<ObjectData> queryColumnAll(@Param("applicationId") String applicationId);

    int insertBatchObjectData(@Param("applicationId") String applicationId, @Param("batchGroupId") Long batchGroupId);

    /**
     * 获取下一个批次id
     */
    Long nextvalBatchGroupId();

    /**
     * 获取当前批次id
     */
    Long currvalBatchGroupId();

    List<Long> queryRepeatHashCode(@Param("applicationId") String applicationId, @Param("batchGroupId") Long batchGroupId);

    List<ObjectData> queryRepeatObjectData(@Param("applicationId") String applicationId, @Param("batchGroupId") Long batchGroupId,
                                           @Param("hashCodes") List<Long> hashCodes);

    List<ObjectData> queryRepeat(@Param("applicationId") String applicationId);

    int queryRepeatCount(@Param("applicationId") String applicationId);


    IPage<ObjectData> queryList(IPage<ObjectData> page, @Param("applicationId") String applicationId);

    int insertMappingBatch(@Param("applicationId") String applicationId);


    int updateMappingBatch(@Param("applicationId") String applicationId);
}