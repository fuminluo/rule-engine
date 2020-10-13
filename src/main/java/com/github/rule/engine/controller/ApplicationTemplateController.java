package com.github.rule.engine.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.service.ApplicationTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板配置表(TApplicationTemplate)表控制层
 *
 * @author makejava
 * @since 2020-10-09 11:02:09
 */
@RestController
@RequestMapping("application/template")
public class ApplicationTemplateController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ApplicationTemplateService applicationTemplateService;


    @GetMapping("/list/{applicationId}")
    public R<?> selectList(@PathVariable String applicationId) {
        Map param = new HashMap<>(2);
        param.put("application_id", applicationId);
        return R.ok(applicationTemplateService.listByMap(param));
    }

    /**
     * 获取入参数
     *
     * @param applicationId
     * @return
     */
    @GetMapping("/in-param/{applicationId}")
    public R<?> getInParam(@PathVariable String applicationId) {
        return R.ok(applicationTemplateService.getInParam(applicationId));
    }

}