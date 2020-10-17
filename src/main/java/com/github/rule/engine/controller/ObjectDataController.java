package com.github.rule.engine.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.rule.engine.dto.ExecuteRequest;
import com.github.rule.engine.dto.InsertBatchObjectRequest;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.service.ObjectDataService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("objectData")
public class ObjectDataController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ObjectDataService objectDataService;

    /**
     * 按维度参数读取规则配置
     *
     * @param executeRequest
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @PostMapping("/execute")
    public R execute(@RequestBody @Validated ExecuteRequest executeRequest) throws NoSuchFieldException, IllegalAccessException {
        log.info(">>> execute : {}", executeRequest.toString());
        return objectDataService.execute(executeRequest);

    }

    /**
     * 新增数据
     *
     * @param insertBatchObjectRequest 实体对象
     * @return 新增结果
     */
    @PostMapping("/insertBatch")
    public R insertBatch(@RequestBody InsertBatchObjectRequest insertBatchObjectRequest) {
        return success(this.objectDataService.insertBatch(insertBatchObjectRequest));
    }

    /**
     * 校验是否重复有重复或时间重叠
     *
     * @param applicationId 应用id
     * @return
     */
    @GetMapping("/validated")
    public R validated(@RequestParam(value = "applicationId") String applicationId) {
        return objectDataService.validated(applicationId);
    }

    /**
     * 读取详细数据
     *
     * @param applicationId
     * @param currentPage
     * @param pageSize
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @GetMapping("/list")
    public R getList(@RequestParam(value = "applicationId") String applicationId,
                     @RequestParam(value = "currentPage", defaultValue = "1") Integer currentPage,
                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) throws NoSuchFieldException, IllegalAccessException {
        return objectDataService.getList(applicationId, currentPage, pageSize);
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