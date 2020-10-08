package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dao.ValueSetDao;
import com.github.rule.engine.entity.ValueSet;
import com.github.rule.engine.service.ValueSetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 值集表(TValueSet)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 22:30:17
 */
@Service
public class ValueSetServiceImpl extends ServiceImpl<ValueSetDao, ValueSet> implements ValueSetService {
    @Resource
    private ValueSetDao valueSetDao;


}