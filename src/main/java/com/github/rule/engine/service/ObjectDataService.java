package com.github.rule.engine.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.dto.InsertBatchObjectRequest;
import com.github.rule.engine.entity.ObjectData;

/**
 * (TObjectData)表服务接口
 *
 * @author makejava
 * @since 2020-10-08 19:06:57
 */
public interface ObjectDataService extends IService<ObjectData> {

    /**
     * 按维度参数读取规则配置
     *
     * @param executeRequest
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    R execute(ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException;

    /**
     * 写入数据
     *
     * @param insertBatchObjectRequest
     * @return
     */
    Integer insertBatch(InsertBatchObjectRequest insertBatchObjectRequest);

    /**
     * 校验是否重复有重复或时间重叠
     *
     * @param applicationId 应用id
     * @return
     */
    R validated(String applicationId);

    /**
     * 读取详细数据
     *
     * @param applicationId
     * @param currentPage
     * @param pageSize
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    R getList(String applicationId, Integer currentPage, Integer pageSize) throws NoSuchFieldException, IllegalAccessException;


    /**
     * 写入hashCode 代替触发器方案
     *
     * @param applicationId
     */
    int updateHashCode(String applicationId);

    /**
     * 删除重复数据
     *
     * @param applicationId 应用id
     * @param batchGroupId 批次id
     * @return
     */
    Integer deleteRepeat(String applicationId, Long batchGroupId);
}