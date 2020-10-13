package com.github.rule.engine.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.service.ObjectDataService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * (TObjectData)表控制层
 *
 * @author makejava
 * @since 2020-10-08 19:06:57
 */
@RestController
@RequestMapping("objectData")
public class ObjectDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ObjectDataService objectDataService;

    @PostMapping("/execute")
    public R execute(@RequestBody @Validated ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException {
        return objectDataService.execute(executeRequest);

    }

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param objectData 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ObjectData> page, ObjectData objectData) {
        return success(this.objectDataService.page(page, new QueryWrapper<>(objectData)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.objectDataService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param objectData 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ObjectData objectData) {
        objectData.setId(UUID.randomUUID().toString().replace("-", ""));
        return success(this.objectDataService.save(objectData));
    }

    /**
     * 修改数据
     *
     * @param objectData 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ObjectData objectData) {
        return success(this.objectDataService.updateById(objectData));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.objectDataService.removeByIds(idList));
    }
}