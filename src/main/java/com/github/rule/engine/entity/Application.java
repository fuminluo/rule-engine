package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * 应用表(TApplication)表实体类
 *
 * @author makejava
 * @since 2020-10-08 19:04:42
 */
@Data
@SuppressWarnings("serial")
@TableName(value = "t_application")
public class Application extends Model<Application> {
    /**
     * 应用id
     */
    private String id;
    /**
     * 应用名称
     */
    private String applicationName;
    /**
     * 应用编码
     */
    private String applicationCode;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 时间戳
     */
    private LocalDate dateTime;
    /**
     * 0-禁用,1-启用
     */
    private String status;
    /**
     * 父id
     */
    private String parentId;
    /**
     * 根id
     */
    private String rootId;
    /**
     * 排序
     */
    private Integer orderSort;

}