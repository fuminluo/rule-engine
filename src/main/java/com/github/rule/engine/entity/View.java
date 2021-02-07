package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * 自定义视图(TView)实体类
 *
 * @author makejava
 * @since 2021-02-07 17:27:05
 */
@TableName("T_VIEW")
public class View implements Serializable {
    private static final long serialVersionUID = -65420897549624302L;
    /**
     * 主键
     */
    private String id;
    /**
     * 视图编码
     */
    private String viewCode;
    /**
     * 视图名称
     */
    private String viewName;
    /**
     * 连接条件
     */
    private String joinOn;
    /**
     * 分组字段
     */
    private String groupColumn;
    /**
     * 完整sql
     */
    @TableField("SQL_STR")
    private String sqlStr;
    /**
     * 过滤条件
     */
    private String filterWhere;
    /**
     * 主表名
     */
    private String masterTableName;
    /**
     * 注入java处理接口，应对sql无法处理业务
     */
    private String javaInterface;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getViewCode() {
        return viewCode;
    }

    public void setViewCode(String viewCode) {
        this.viewCode = viewCode;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getJoinOn() {
        return joinOn;
    }

    public void setJoinOn(String joinOn) {
        this.joinOn = joinOn;
    }

    public String getGroupColumn() {
        return groupColumn;
    }

    public void setGroupColumn(String groupColumn) {
        this.groupColumn = groupColumn;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }

    public String getFilterWhere() {
        return filterWhere;
    }

    public void setFilterWhere(String filterWhere) {
        this.filterWhere = filterWhere;
    }

    public String getMasterTableName() {
        return masterTableName;
    }

    public void setMasterTableName(String masterTableName) {
        this.masterTableName = masterTableName;
    }

    public String getJavaInterface() {
        return javaInterface;
    }

    public void setJavaInterface(String javaInterface) {
        this.javaInterface = javaInterface;
    }

}