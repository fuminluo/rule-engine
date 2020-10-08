package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dao.TemplateDao;
import com.github.rule.engine.entity.Template;
import com.github.rule.engine.service.TemplateService;
import org.springframework.stereotype.Service;

/**
 * 模板表(TTemplate)表服务实现类
 *
 * @author makejava
 * @since 2020-10-08 00:33:31
 */
@Service
public class TemplateServiceImpl extends ServiceImpl<TemplateDao, Template> implements TemplateService {

}