package com.github.rule.engine.controller;

import com.github.rule.engine.config.NumberGenerator;
import com.github.rule.engine.dto.InstanceBuildContext;
import com.github.rule.engine.dto.OptionDTO;
import com.github.rule.engine.service.impl.PipelineExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2020/12/28 15:28
 */
@RestController
public class TestController {

    @PostMapping("/test")
    public Object test(@NumberGenerator OptionDTO optionDTO) {

        return optionDTO;
    }

    @Autowired
    PipelineExecutor pipelineExecutor;

    @GetMapping("/test2")
    public Object test2() {
        InstanceBuildContext data = new InstanceBuildContext();
        data.setUserId(1L);
        Map map = new HashMap();
        map.put("instanceName", "instanceName");
        data.setFormInput(map);
        boolean success = pipelineExecutor.acceptSync(data);
        return data.getErrorMsg();
    }
}
