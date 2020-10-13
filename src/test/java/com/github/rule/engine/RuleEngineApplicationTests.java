package com.github.rule.engine;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.service.ObjectDataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class RuleEngineApplicationTests {

    @Resource
    private ObjectDataService objectDataService;

    @Test
    void contextLoads() throws NoSuchFieldException, IllegalAccessException {
        ExecuteRequest executeRequest = new ExecuteRequest();
        executeRequest.setApplicationCode("Travel Allowance");
        Map param = new HashMap<>();
        param.put("company", "001");
        param.put("dept", "002");
        param.put("post", "003");
        param.put("classOfPositions", "004");
        executeRequest.setParam(param);
        R r = objectDataService.execute(executeRequest);
        log.info("结果 ： {}", r.toString());
    }

}
