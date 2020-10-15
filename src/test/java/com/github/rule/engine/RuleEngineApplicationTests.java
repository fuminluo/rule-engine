package com.github.rule.engine;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.service.ObjectDataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        param.put("company", "001");
        param.put("dept", "002");
        param.put("post", "003");
        param.put("classOfPositions", "004");
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

    @Test
    void testQuery1() {
        List<Long> hashCodes = new ArrayList<>();
        hashCodes.add(Long.valueOf(1));
        hashCodes.add(Long.valueOf(2));
        objectDataMapper.queryRepeatObjectData("abc", Long.valueOf(26), hashCodes);
    }

}
