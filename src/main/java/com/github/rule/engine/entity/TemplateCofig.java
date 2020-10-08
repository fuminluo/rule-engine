package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 模板配置表(TTemplateCofig)表实体类
 *
 * @author makejava
 * @since 2020-10-08 18:57:50
 */
@Data
@TableName(value = "t_template_config")
@SuppressWarnings("serial")
public class TemplateCofig extends Model<TemplateCofig> {
    //配置id
    @TableId(type = IdType.UUID)
    private String id;
    //段值编码
    private String segmentCode;
    //段值名称
    private String segmentName;
    //数据库列名称
    private String columnName;
    //数据库列类型:字符、数字、时间
    private String columnType;
    //是否必填:Y-是,N-否
    private String isRequest;
    //备注
    private String remarks;
    //配置id
    private String templateId;
    //自定义取值sql
    private String customSql;
    //断值数据类型:字符、数字、时间
    private String segmentType;
    //排序字段
    private Integer orderSort;
    //时间戳
    private LocalDate dateTime;
    //0-禁用,1-启用
    private String status;
    //输入:IN、输出:OUT、输入和输出:INOUT
    private String inOut;
    //是否关联:Y-是,N-否
    private String isJoin;
    //关联父节点编码
    private String joinCode;


    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}