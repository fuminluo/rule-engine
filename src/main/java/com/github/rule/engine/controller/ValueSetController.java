package com.github.rule.engine.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ValueSetRequest;
import com.github.rule.engine.service.ValueSetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 值集表(TValueSet)表控制层
 *
 * @author makejava
 * @since 2020-10-07 22:30:18
 */
@RestController
@RequestMapping("valueSet")
public class ValueSetController {
    /**
     * 服务对象
     */
    @Resource
    private ValueSetService valueSetService;


    /**
     * 值集接口
     *
     * @return
     */
    @GetMapping("/segment")
    public R<?> findvalueSet(@ModelAttribute ValueSetRequest valueSetRequest) {

        return valueSetService.findvalueSet(valueSetRequest);
    }

}