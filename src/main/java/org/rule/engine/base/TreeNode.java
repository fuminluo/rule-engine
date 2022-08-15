package org.rule.engine.base;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

/**
 * 构建树工具
 **/
public class TreeNode<T, E> implements Serializable {

    private static final long serialVersionUID = -5179366900279452235L;

    @TableField(exist = false)
    protected T id;

    @TableField(exist = false)
    protected T parentId;

    @TableField(exist = false)
    protected List<E> children;

    public TreeNode() {
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public T getParentId() {
        return parentId;
    }

    public void setParentId(T parentId) {
        this.parentId = parentId;
    }

    public List<E> getChildren() {
        return children;
    }

    public void setChildren(List<E> children) {
        this.children = children;
    }
}
