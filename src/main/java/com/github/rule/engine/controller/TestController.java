package com.github.rule.engine.controller;

import com.github.rule.engine.config.NumberGenerator;
import com.github.rule.engine.dto.InstanceBuildContext;
import com.github.rule.engine.dto.LatchPipelineContext;
import com.github.rule.engine.dto.OptionDTO;
import com.github.rule.engine.dto.PipelineContext;
import com.github.rule.engine.executor.Executor;
import com.github.rule.engine.executor.PipelineExecutor;
import com.github.rule.engine.handler.*;
import com.github.rule.engine.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Consumer;

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

    @GetMapping("/test3")
    public Object test3() throws InterruptedException {
        InstanceBuildContext pipelineContext = new InstanceBuildContext();
        Map<String, List<? extends ContextHandler<? super PipelineContext>>> datas = new HashMap<>(8);
        List<? extends ContextHandler<? extends PipelineContext>> list =
                Arrays.asList(SpringContextUtils.getBean(InputDataPreChecker.class));
        datas.put("handler", (List<? extends ContextHandler<? super PipelineContext>>) list);
        Consumer<PipelineContext> consumer = context -> {
            datas.forEach((k, v) -> {
                v.forEach(var -> {
                    if (context.isHandleResult()) {
                        try {
                            if (!var.handle(context)) {
                                context.setHandleResult(false);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            context.setHandleResult(false);
                        }

                    }
                });
            });
        };
        Executor executor = SpringContextUtils.getBean(PipelineExecutor.class);
        executor.acceptSync(pipelineContext, consumer);
        return pipelineContext;
    }


}
