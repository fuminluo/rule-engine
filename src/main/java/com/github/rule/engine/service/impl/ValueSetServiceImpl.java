package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dto.ValueSetRequest;
import com.github.rule.engine.mapper.ValueSetMapper;
import com.github.rule.engine.entity.ValueSet;
import com.github.rule.engine.service.ValueSetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 值集表(TValueSet)表服务实现类
 *
 * @author makejava
 * @since 2020-10-07 22:30:17
 */
@Service
public class ValueSetServiceImpl extends ServiceImpl<ValueSetMapper, ValueSet> implements ValueSetService {
    @Resource
    private ValueSetMapper valueSetMapper;


    @Override
    public R<?> findvalueSet(ValueSetRequest valueSetRequest) {
        List list = valueSetMapper.findvalueSet(valueSetRequest);
        return R.ok(list);
    }
}