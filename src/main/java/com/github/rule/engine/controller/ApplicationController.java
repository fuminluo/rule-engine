package com.github.rule.engine.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.rule.engine.dto.ApplicationTreeView;
import com.github.rule.engine.entity.Application;
import com.github.rule.engine.service.ApplicationService;
import com.github.rule.engine.utils.TreeNodeUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 应用表(TApplication)表控制层
 *
 * @author makejava
 * @since 2020-10-08 19:04:43
 */
@RestController
@RequestMapping("application")
public class ApplicationController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ApplicationService applicationService;


    /**
     * 获取应用数
     *
     * @return List<ApplicationTreeView>
     */
    @GetMapping("/tree")
    public R<List<ApplicationTreeView>> findTree() {
        return applicationService.findTree();
    }

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param application 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Application> page, Application application) {
        return success(this.applicationService.page(page, new QueryWrapper<>(application)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.applicationService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param application 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Application application) {
        return success(this.applicationService.save(application));
    }

    /**
     * 修改数据
     *
     * @param application 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Application application) {
        return success(this.applicationService.updateById(application));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.applicationService.removeByIds(idList));
    }
}