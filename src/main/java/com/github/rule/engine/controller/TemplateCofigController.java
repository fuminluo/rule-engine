package com.github.rule.engine.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.rule.engine.entity.TemplateCofig;
import com.github.rule.engine.service.TemplateCofigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 模板配置表(TTemplateCofig)表控制层
 *
 * @author makejava
 * @since 2020-10-08 18:57:50
 */
@RestController
@RequestMapping("tTemplateCofig")
public class TemplateCofigController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TemplateCofigService templateCofigService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param templateCofig 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<TemplateCofig> page, TemplateCofig templateCofig) {
        return success(this.templateCofigService.page(page, new QueryWrapper<>(templateCofig)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.templateCofigService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param templateCofig 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody TemplateCofig templateCofig) {
        return success(this.templateCofigService.save(templateCofig));
    }

    /**
     * 修改数据
     *
     * @param templateCofig 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody TemplateCofig templateCofig) {
        return success(this.templateCofigService.updateById(templateCofig));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.templateCofigService.removeByIds(idList));
    }
}