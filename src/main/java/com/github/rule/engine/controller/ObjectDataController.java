package com.github.rule.engine.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.service.TObjectDataService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (TObjectData)表控制层
 *
 * @author makejava
 * @since 2020-10-08 19:06:57
 */
@RestController
@RequestMapping("tObjectData")
public class ObjectDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private TObjectDataService tObjectDataService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param objectData 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ObjectData> page, ObjectData objectData) {
        return success(this.tObjectDataService.page(page, new QueryWrapper<>(objectData)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.tObjectDataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param objectData 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ObjectData objectData) {
        return success(this.tObjectDataService.save(objectData));
    }

    /**
     * 修改数据
     *
     * @param objectData 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ObjectData objectData) {
        return success(this.tObjectDataService.updateById(objectData));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.tObjectDataService.removeByIds(idList));
    }
}