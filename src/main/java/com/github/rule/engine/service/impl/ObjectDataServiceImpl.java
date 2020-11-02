package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlKeyword;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dto.ApplicationTableDTO;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.dto.InsertBatchObjectRequest;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.mapper.ApplicationMapper;
import com.github.rule.engine.mapper.ApplicationTemplateMapper;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.service.AbstractExecuteService;
import com.github.rule.engine.service.ObjectDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * (TObjectData)表服务实现类
 *
 * @author makejava
 * @since 2020-10-08 19:06:57
 */
@Slf4j
@Service
public class ObjectDataServiceImpl extends ServiceImpl<ObjectDataMapper, ObjectData> implements ObjectDataService {

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    ApplicationTemplateMapper applicationTemplateMapper;

    @Autowired
    ObjectDataMapper objectDataMapper;

    /**
     * 按维度参数读取规则配置
     *
     * @param executeRequest
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Override
    public R execute(ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException {
        AbstractExecuteService defaultExecuteObjectData = new DefaultExecuteServiceImpl(executeRequest);
        R result = defaultExecuteObjectData.doExecute();
        return result;
    }

    /**
     * 写入数据
     *
     * @param batchObjectRequest
     * @return
     */
    @Override
    @Transactional
    public Integer insertBatch(InsertBatchObjectRequest batchObjectRequest) {
        //写入临时表
        objectDataMapper.insertColumnBatch(batchObjectRequest);
        //获取批次id
        Long batchGroupId = objectDataMapper.nextvalBatchGroupId();
        //写入正式表
        int count = objectDataMapper.insertBatchObjectData(batchObjectRequest.getApplicationId(), batchGroupId);
        //写入翻译表
        objectDataMapper.insertMappingBatch(batchObjectRequest.getApplicationId());
        return count;
    }

    /**
     * 校验是否重复有重复或时间重叠
     *
     * @param applicationId 应用id
     * @return
     */
    @Override
    public R validated(String applicationId) {
        //校验逻辑因业务差异需要自己实现
        List<ObjectData> objectDataList = objectDataMapper.queryRepeat(applicationId);
        if (CollectionUtils.isEmpty(objectDataList)) {
            return R.ok("无重复数据");
        }
        log.info(" >>> sql重复数据：{}", objectDataList.size());
        return R.ok(objectDataList);
    }

    /**
     * 校验是否重复有重复或时间重叠(java)
     *
     * @param applicationId 应用id
     * @return
     */
    @Override
    public R validatedInJava(String applicationId) {
        List<ObjectData> objectDataList = objectDataMapper.queryHashCodeRepeat(applicationId);
        if (CollectionUtils.isEmpty(objectDataList)) {
            return R.ok("无重复数据");
        }
        log.info("重复数据行数 ：{}", objectDataList.size());
        Map<Long, List<ObjectData>> objectDataListMap = objectDataList.stream().collect(Collectors.groupingBy(ObjectData::getHashCode));
        log.info("objectDataListMap size ：{}", objectDataListMap.size());
        Set<ObjectData> errorSet = new HashSet<>(objectDataList.size());
        //分组后 可以使用多线程运算相同hashcode的分组进行比较
        for (Map.Entry<Long, List<ObjectData>> entry : objectDataListMap.entrySet()) {
            List<ObjectData> objList = entry.getValue();
            for (ObjectData oriObj : objList) {
                for (ObjectData tarObj : objList) {
                    if (!oriObj.getId().equals(tarObj.getId())) {
                        if (compare(oriObj.getColumnDate1(), tarObj.getColumnDate1(), tarObj.getColumnDate2())
                                || compare(oriObj.getColumnDate2(), tarObj.getColumnDate1(), tarObj.getColumnDate2())) {
                            errorSet.add(oriObj);
                            errorSet.add(tarObj);
                        }
                    }
                }
            }
        }
        log.info(">>> java重复数据：{}", errorSet.size());
        return R.ok(errorSet);
    }


    private static Boolean compare(LocalDateTime time, LocalDateTime lowerTime, LocalDateTime upperTime) {
        return (time.isAfter(lowerTime) && time.isBefore(upperTime)) || (time.isEqual(lowerTime) || time.isEqual(upperTime));
    }

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
    @Override
    public R getList(String applicationId, Integer currentPage, Integer pageSize) throws NoSuchFieldException, IllegalAccessException {
        IPage<ObjectData> page = new Page<>(currentPage, pageSize);
        page = objectDataMapper.queryList(page, applicationId);
        List<ObjectData> list = page.getRecords();
        List<ApplicationTemplate> applicationTemplateList = applicationTemplateMapper.findListByApplicationId(applicationId);
        Map<String, String> templateMap = applicationTemplateList.
                stream().collect(Collectors.toMap(ApplicationTemplate::getSegmentCode, ApplicationTemplate::getFieldName));
        List<Map> resultList = new ArrayList<>(list.size());
        for (ObjectData obj : list) {
            Map value = new HashMap(12);
            for (Map.Entry<String, String> entry : templateMap.entrySet()) {
                Field field = obj.getClass().getDeclaredField(entry.getValue());
                //对private的属性的访问
                field.setAccessible(true);
                Object data = field.get(obj);
                value.put(entry.getKey(), data);
            }
            value.put("dateTime", obj.getDateTime());
            value.put("applicationId", obj.getApplicationId());
            value.put("status", obj.getStatus());
            value.put("id", obj.getId());
            resultList.add(value);
        }
        return R.ok(resultList);
    }

    /**
     * 写入hashCode 替代触发器
     *
     * @param applicationId
     */
    @Override
    @Transactional
    public int updateHashCode(String applicationId) {
        List<String> columnNames = applicationTemplateMapper.queryColumnName(applicationId);
        String sqlStr = "update T_OBJECT_DATA2 set hash_code = ora_hash(%s) where hash_code = 0";
        sqlStr = String.format(sqlStr, "'" + applicationId + "'" + "||" + columnNames.stream().collect(Collectors.joining("||")));
        log.info(">>> sqlStr : {}", sqlStr);
        return objectDataMapper.updateHashcode(sqlStr);
    }

    /**
     * 删除重复数据
     *
     * @param applicationId 应用id
     * @param batchGroupId  批次id
     * @return
     */
    @Override
    @Transactional
    public Integer deleteRepeat(String applicationId, Long batchGroupId) {
        return objectDataMapper.deleteRepeat(applicationId, batchGroupId);
    }
}