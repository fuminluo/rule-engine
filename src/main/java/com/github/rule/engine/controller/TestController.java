package com.github.rule.engine.controller;

import com.github.rule.engine.config.NumberGenerator;
import com.github.rule.engine.dto.InstanceBuildContext;
import com.github.rule.engine.dto.LatchPipelineContext;
import com.github.rule.engine.dto.OptionDTO;
import com.github.rule.engine.dto.PipelineContext;
import com.github.rule.engine.service.ContextHandler;
import com.github.rule.engine.service.impl.*;
import com.github.rule.engine.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    @Autowired
    ContextHandler modelInstanceCreator;

    @GetMapping("/test")
    public Object test() throws InterruptedException {
        InstanceBuildContext data = new InstanceBuildContext();
        data.setUserId(1L);
        Map map = new HashMap();
        map.put("instanceName", "instanceName");
        data.setFormInput(map);
        //boolean success = pipelineExecutor.acceptSync(data);
        //List list = Arrays.asList(SpringContextUtils.getBean(ModelInstanceCreator.class));
        //pipelineExecutor.acceptAsync(data, list);

        return data.getErrorMsg();
    }

    @GetMapping("/test2")
    public Object test2() throws InterruptedException {
        LatchPipelineContext data = new LatchPipelineContext();
        data.setWaitTime(1);
        List<? extends ContextHandler<? extends PipelineContext>> list =
                Arrays.asList(SpringContextUtils.getBean(LatchTest.class),
                SpringContextUtils.getBean(LatchTest2.class),
                SpringContextUtils.getBean(LatchTest3.class));
        pipelineExecutor.acceptSync(data, (List<? extends ContextHandler<? super PipelineContext>>) list);
        return data;
    }
}
