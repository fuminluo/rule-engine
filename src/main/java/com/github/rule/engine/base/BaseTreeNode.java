package com.github.rule.engine.base;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 86186
 */
@Data
public  class BaseTreeNode implements Serializable {

    private static final long serialVersionUID = 661466066923789608L;

    /**
     * 子Id
     */
    private String id;

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 层级
     */
    private Integer level;

    private List<BaseTreeNode> children;

    public void addChildren(BaseTreeNode baseTreeNode) {
        if (this.children == null) {
            this.setChildren(new ArrayList());
        }
        this.getChildren().add(baseTreeNode);
    }
}
