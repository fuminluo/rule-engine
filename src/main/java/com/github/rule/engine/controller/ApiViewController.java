package com.github.rule.engine.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.github.rule.engine.dto.ApiViewDTO;
import com.github.rule.engine.dto.ApplicationTreeView;
import com.github.rule.engine.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * @Author LuoFuMin
 * @DATE 2021/2/7 17:14
 */
@RestController
@RequestMapping("api/view")
public class ApiViewController {

    @Autowired
    ViewService viewService;

    /**
     * 获取应用数
     *
     * @return List<ApplicationTreeView>
     */
    @PostMapping("/data")
    public R<?> findData(@RequestBody @Validated ApiViewDTO apiViewDTO) {
        return R.ok(viewService.findData(apiViewDTO));
    }

}
