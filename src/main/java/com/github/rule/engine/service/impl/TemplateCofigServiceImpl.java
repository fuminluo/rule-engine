package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dao.TemplateCofigDao;
import com.github.rule.engine.entity.TemplateCofig;
import com.github.rule.engine.service.TemplateCofigService;
import org.springframework.stereotype.Service;

/**
 * 模板配置表(TTemplateCofig)表服务实现类
 *
 * @author makejava
 * @since 2020-10-08 18:57:50
 */
@Service("tTemplateCofigService")
public class TemplateCofigServiceImpl extends ServiceImpl<TemplateCofigDao, TemplateCofig> implements TemplateCofigService {

}