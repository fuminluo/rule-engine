package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 模板表(TTemplate)表实体类
 *
 * @author makejava
 * @since 2020-10-08 00:33:31
 */
@Data
@SuppressWarnings("serial")
@TableName(value = "t_template")
public class Template extends Model<Template> {

    @TableId(type = IdType.UUID)
    private String id;
    //模板名称
    private String templateName;
    //应用id
    private String applicationId;
    //时间戳
    private LocalDate dateTime;
    //0-禁用,1-启用
    private Integer status;
    //备注
    private String remarks;


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