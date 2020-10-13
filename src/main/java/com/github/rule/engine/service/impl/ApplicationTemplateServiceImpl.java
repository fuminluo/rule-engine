package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.entity.ApplicationTemplate;
import com.github.rule.engine.mapper.ApplicationTemplateMapper;
import com.github.rule.engine.service.ApplicationTemplateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 模板配置表(TApplicationTemplate)表服务实现类
 *
 * @author makejava
 * @since 2020-10-09 11:02:09
 */
@Service
public class ApplicationTemplateServiceImpl extends ServiceImpl<ApplicationTemplateMapper, ApplicationTemplate> implements ApplicationTemplateService {
    @Resource
    private ApplicationTemplateMapper applicationTemplateMapper;


    @Override
    public R<?> getInParam(String applicationId) {
        List<String> list = applicationTemplateMapper.getInParam(applicationId,"IN");
        return R.ok(list);
    }
}