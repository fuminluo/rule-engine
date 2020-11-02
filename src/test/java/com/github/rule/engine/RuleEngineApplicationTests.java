package com.github.rule.engine;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.dto.InsertBatchObjectRequest;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.service.ObjectDataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

@SpringBootTest
@Slf4j
class RuleEngineApplicationTests {

    @Resource
    private ObjectDataService objectDataService;

    @Autowired
    ObjectDataMapper objectDataMapper;

    /**
     * 简单测试方法
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    void contextLoads() throws NoSuchFieldException, IllegalAccessException {
        ExecuteRequest executeRequest = new ExecuteRequest();
        executeRequest.setApplicationId("6525D9B9ADBF4C5EA8942607BBEFB985");
        Map param = new HashMap<>();
        param.put("company", "A001");
        param.put("dept", "B002");
        param.put("post", "C001");
        param.put("classOfPositions", "D001");
        executeRequest.setParam(param);
        R r = objectDataService.execute(executeRequest);
        log.info("结果 ： {}", r.toString());
    }

    @Test
    void testQuery() {
        QueryWrapper<ObjectData> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply(false, "hash_code=1", 1);
        objectDataService.list(queryWrapper);
    }

    /**
     * 导入测试 （导入: 27648 条数据  耗时：10866 ms）
     */
    @Test
    void insertBatch() {
        Long startTime = System.currentTimeMillis();
        InsertBatchObjectRequest insertBatchObjectRequest = new InsertBatchObjectRequest();
        insertBatchObjectRequest.setApplicationId("6525D9B9ADBF4C5EA8942607BBEFB985");
        insertBatchObjectRequest.setColumnChar1(new ArrayList<String>(Arrays.asList("A003", "A004")));
        insertBatchObjectRequest.setColumnChar2(new ArrayList<String>(Arrays.asList("B001", "B002", "B003", "B004", "B005", "B006", "B007", "B008", "B009", "B0010", "B0011", "B0012", "B0013", "B0014", "B0015", "B0016")));
        insertBatchObjectRequest.setColumnChar3(new ArrayList<String>(Arrays.asList("C001", "C002", "C003", "C004", "C005", "C006")));
        insertBatchObjectRequest.setColumnChar4(new ArrayList<String>(Arrays.asList("D001", "D002", "D003", "D004")));
        insertBatchObjectRequest.setColumnChar5(new ArrayList<String>(Arrays.asList("CNY")));
        insertBatchObjectRequest.setColumnChar6(new ArrayList<String>(Arrays.asList("Y")));
        insertBatchObjectRequest.setColumnNumber1(new ArrayList<BigDecimal>(Arrays.asList(BigDecimal.valueOf(100))));
        insertBatchObjectRequest.setColumnDate1(new ArrayList<String>(Arrays.asList("2010.1.1")));
        insertBatchObjectRequest.setColumnDate2(new ArrayList<String>(Arrays.asList("2012.1.1")));
        int count = objectDataService.insertBatch(insertBatchObjectRequest);
        Long endTime = System.currentTimeMillis();
        System.out.println("导入: " + count + " 条数据" + "  耗时：" + (endTime - startTime) + "ms");
    }

    /**
     * 写入hashCode 代替触发器方案
     */
    @Test
    void updateHashCode() {

        objectDataService.updateHashCode("6525D9B9ADBF4C5EA8942607BBEFB985");
    }


    /**
     * 导入测试 （导入: 27648 条数据  耗时：10866 ms）
     */
    @Test
    void insertBatch2() {
        Long startTime = System.currentTimeMillis();
        InsertBatchObjectRequest insertBatchObjectRequest = new InsertBatchObjectRequest();
        insertBatchObjectRequest.setApplicationId("6525D9B9ADBF4C5EA8942607BBEFB985");
        insertBatchObjectRequest.setColumnChar1(new ArrayList<String>(Arrays.asList("A001")));
        insertBatchObjectRequest.setColumnChar2(new ArrayList<String>(Arrays.asList("B001")));
        insertBatchObjectRequest.setColumnChar3(new ArrayList<String>(Arrays.asList("C001")));
        insertBatchObjectRequest.setColumnChar4(new ArrayList<String>(Arrays.asList("D001")));
        insertBatchObjectRequest.setColumnChar5(new ArrayList<String>(Arrays.asList("CNY")));
        insertBatchObjectRequest.setColumnChar6(new ArrayList<String>(Arrays.asList("N")));
        insertBatchObjectRequest.setColumnNumber1(new ArrayList<BigDecimal>(Arrays.asList(BigDecimal.valueOf(150))));
        insertBatchObjectRequest.setColumnDate1(new ArrayList<String>(Arrays.asList("1997.1.1")));
        insertBatchObjectRequest.setColumnDate2(new ArrayList<String>(Arrays.asList("1998.1.1")));
        int count = objectDataService.insertBatch(insertBatchObjectRequest);
        Long endTime = System.currentTimeMillis();
        System.out.println("导入: " + count + " 条数据" + "  耗时：" + (endTime - startTime) + "ms");
    }



}
