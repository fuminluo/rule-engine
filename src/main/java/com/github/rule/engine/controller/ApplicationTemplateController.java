package com.github.rule.engine.controller;

import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.entity.ValueSet;
import com.github.rule.engine.service.ApplicationTemplateService;
import org.springframework.web.bind.annotation.*;

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


    /**
     * 修改数据
     *
     * @param applicationTemplate 实体对象
     * @return 修改结果
     */
    @PostMapping("/save")
    public R saveOrUpdate(@RequestBody ApplicationTemplate applicationTemplate) {
        return success(this.applicationTemplateService.saveOrUpdate(applicationTemplate));
    }

}