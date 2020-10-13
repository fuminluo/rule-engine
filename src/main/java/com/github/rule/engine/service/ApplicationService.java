package com.github.rule.engine.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.rule.engine.dto.ApplicationTreeView;
import com.github.rule.engine.entity.Application;

import java.util.List;

/**
 * 应用表(TApplication)表服务接口
 *
 * @author makejava
 * @since 2020-10-08 19:04:43
 */
public interface ApplicationService extends IService<Application> {

    R<List<ApplicationTreeView>> findTree();
}