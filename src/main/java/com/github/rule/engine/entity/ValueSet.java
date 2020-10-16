package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * 值集表(TValueSet)实体类
 *
 * @author makejava
 * @since 2020-10-07 22:30:14
 */
@Data
@TableName(value = "t_value_set")
@SuppressWarnings("serial")
public class ValueSet extends Model<ValueSet> {
    /**
     * 主键
     */
    @TableId(type = IdType.UUID)
    private String id;
    /**
     * 应用id
     */
    private String applicationId;
    /**
     * 值编码
     */
    private String valueCode;
    /**
     * 数据类型:1-String,2-Number,3-Date
     */
    private String dataType;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 0-禁用,1-启用
     */
    private Integer status;
    /**
     * 时间戳
     */
    private LocalDate dateTime;
    /**
     * 段值名称
     */
    private String segmentName;
    /**
     * 段值编码
     */
    private String segmentCode;
    /**
     * 值编码父code,用于构建树
     */
    private String valueParentCode;
    /**
     * 值名称
     */
    private String valueName;

    /**
     * 应用根id
     */
    private String rootId;


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