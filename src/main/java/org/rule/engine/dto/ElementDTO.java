package org.rule.engine.dto;



import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author work
 * @since 2022-08-15
 */
public class ElementDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
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
    @NotBlank(message = "eleCode不能为空")
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
     * 数据结构：1-树，2-枚举
     */
    private Integer structure;


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

    public Integer getStructure() {
        return structure;
    }

    public void setStructure(Integer structure) {
        this.structure = structure;
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
                ", structure=" + structure +
                "}";
    }
}
