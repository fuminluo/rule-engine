package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 模板配置表(TApplicationTemplate)实体类
 *
 * @author makejava
 * @since 2020-10-09 11:02:07
 */
@Data
@SuppressWarnings("serial")
@TableName(value = "t_application_template")
public class ApplicationTemplate extends Model<ApplicationTemplate> implements Serializable {

    private static final long serialVersionUID = -79677609541154456L;
    /**
     * 配置id
     */
    @TableId(value = "id",type = IdType.UUID)
    private String id;
    /**
     * 段值编码
     */
    private String segmentCode;
    /**
     * 段值名称
     */
    private String segmentName;
    /**
     * 数据库列名称
     */
    private String columnName;
    /**
     * 数据库列类型:字符、数字、时间
     */
    private String columnType;
    /**
     * 是否必填:Y-是,N-否
     */
    private String isRequest;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 自定义取值sql
     */
    private String customSql;
    /**
     * 段值数据类型:字符、数字、时间
     */
    private String segmentType;
    /**
     * 排序字段
     */
    private String orderSort;
    /**
     * 时间戳
     */
    private LocalDate dateTime;
    /**
     * 0-禁用,1-启用
     */
    private String status;
    /**
     * 输入:IN、输出:OUT、输入和输出:INOUT
     */
    private String inOut;
    /**
     * 是否关联:Y-是,N-否
     */
    private String isJoin;
    /**
     * 关联父节点编码
     */
    private String joinCode;
    /**
     * 应用id
     */
    private String applicationId;

    /**
     * java属性名称
     */
    private String fieldName;

    /**
     * java属性类型
     */
    private String fieldType;

    /**
     * 运算规则
     */
    private String arithmetic;

}