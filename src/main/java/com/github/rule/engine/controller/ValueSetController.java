package com.github.rule.engine.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.rule.engine.dto.ValueSetRequest;
import com.github.rule.engine.entity.ValueSet;
import com.github.rule.engine.service.ValueSetService;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * 值集表(TValueSet)表控制层
 *
 * @author makejava
 * @since 2020-10-07 22:30:18
 */
@RestController
@RequestMapping("valueSet")
public class ValueSetController extends ApiController {
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

    /**
     * excel 导入
     *
     * @param file
     * @param applicationId
     * @return
     * @throws Exception
     */
    @PostMapping("/import/excel")
    public R<?> importValueSet(@RequestParam("file") MultipartFile file,
                               @RequestParam("applicationId") String applicationId) throws Exception {
        return valueSetService.importValueSet(file, applicationId);
    }


    /**
     * excel 导入
     *
     * @param applicationId
     * @return
     * @throws Exception
     */
    @GetMapping("/excel/template")
    public void getExcelTemplate(@RequestParam("applicationId") String applicationId) throws Exception {
        valueSetService.getExcelTemplate(applicationId);
    }

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param valueSet 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<ValueSet> page, ValueSet valueSet) {
        return success(this.valueSetService.page(page, new QueryWrapper<>(valueSet)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.valueSetService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param valueSet 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody ValueSet valueSet) {
        return success(this.valueSetService.save(valueSet));
    }


    /**
     * 修改数据
     *
     * @param valueSet 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody ValueSet valueSet) {
        return success(this.valueSetService.updateById(valueSet));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.valueSetService.removeByIds(idList));
    }
}