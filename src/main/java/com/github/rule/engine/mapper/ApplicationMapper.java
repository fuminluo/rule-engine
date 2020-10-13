package com.github.rule.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.rule.engine.dto.ApplicationTreeView;
import com.github.rule.engine.entity.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 应用表(TApplication)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-08 19:04:43
 */
@Mapper
public interface ApplicationMapper extends BaseMapper<Application> {

    List<ApplicationTreeView> findTree();

}