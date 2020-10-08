package com.github.rule.engine.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BaseTreeNode {

    /**
     * 子Id
     */
    private String id;
    /**
     * 父ID
     */
    private String pId;

    private List<BaseTreeNode> children;

    public void addChildren(BaseTreeNode baseTreeNode) {
        if (this.children == null) {
            this.setChildren(new ArrayList());
        }
        this.getChildren().add(baseTreeNode);
    }
}
