package com.github.rule.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.rule.engine.entity.ValueSet;
import org.apache.ibatis.annotations.Mapper;

/**
 * 值集表(TValueSet)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-07 22:30:15
 */
@Mapper
public interface ValueSetMapper extends BaseMapper<ValueSet> {



}