package com.github.rule.engine.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.rule.engine.entity.ApplicationTemplate;

/**
 * 模板配置表(TApplicationTemplate)表服务接口
 *
 * @author makejava
 * @since 2020-10-09 11:02:09
 */
public interface ApplicationTemplateService extends IService<ApplicationTemplate> {

    R<?> getInParam(String applicationId);
}