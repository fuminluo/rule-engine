package org.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.rule.engine.base.TreeNode;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author work
 * @since 2022-08-15
 */
@TableName("t_dictionary")
public class Dictionary extends TreeNode<Long, Dictionary> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 代码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 元素编码
     */
    private String eleCode;

    /**
     * 层级
     */
    private Integer levelNo;

    /**
     * 排序字段
     */
    private Integer sortNo;

    /**
     * 父id
     */
    private Long parentId;

    /**
     * 备注
     */
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEleCode() {
        return eleCode;
    }

    public void setEleCode(String eleCode) {
        this.eleCode = eleCode;
    }

    public Integer getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Integer levelNo) {
        this.levelNo = levelNo;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TDictionary{" +
                "id=" + id +
                ", code=" + code +
                ", name=" + name +
                ", eleCode=" + eleCode +
                ", levelNo=" + levelNo +
                ", sortNo=" + sortNo +
                ", parentId=" + parentId +
                ", remark=" + remark +
                "}";
    }
}
