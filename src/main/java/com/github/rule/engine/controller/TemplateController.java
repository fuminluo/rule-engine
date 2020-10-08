package com.github.rule.engine.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.rule.engine.entity.Template;
import com.github.rule.engine.service.TemplateService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 模板表(TTemplate)表控制层
 *
 * @author makejava
 * @since 2020-10-08 00:33:31
 */
@RestController
@RequestMapping("tTemplate")
public class TemplateController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TemplateService templateService;

    /**
     * 分页查询所有数据
     *
     * @param page      分页对象
     * @param template 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Template> page, Template template) {
        return success(this.templateService.page(page, new QueryWrapper<>(template)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.templateService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param template 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Template template) {
        return success(this.templateService.save(template));
    }

    /**
     * 修改数据
     *
     * @param template 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Template template) {
        return success(this.templateService.updateById(template));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.templateService.removeByIds(idList));
    }
}