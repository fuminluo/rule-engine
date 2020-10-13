package com.github.rule.engine.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.rule.engine.entity.ApplicationTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 模板配置表(TApplicationTemplate)表数据库访问层
 *
 * @author makejava
 * @since 2020-10-09 11:02:07
 */
@Mapper
public interface ApplicationTemplateMapper extends BaseMapper<ApplicationTemplate> {


    List<String> getInParam(@Param("applicationId") String applicationId, @Param("inOut") String inOut);

    List<ApplicationTemplate> findListByApplicationCode(@Param("applicationCode") String applicationCode);
}