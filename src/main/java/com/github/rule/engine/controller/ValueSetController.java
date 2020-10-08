package com.github.rule.engine.controller;

import com.github.rule.engine.entity.ValueSet;
import com.github.rule.engine.service.ValueSetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 值集表(TValueSet)表控制层
 *
 * @author makejava
 * @since 2020-10-07 22:30:18
 */
@RestController
@RequestMapping("tValueSet")
public class ValueSetController {
    /**
     * 服务对象
     */
    @Resource
    private ValueSetService valueSetService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public List selectOne(String id) {
        return valueSetService.list();
    }

}