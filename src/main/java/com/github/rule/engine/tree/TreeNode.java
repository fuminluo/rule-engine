package com.github.rule.engine.tree;

import com.github.rule.engine.base.BaseTreeNode;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2020/12/26 11:44
 */
@Data
public class TreeNode extends BaseTreeNode {

    /**
     * 取数集合
     */
    private Map<String, String> query;

    /**
     * 变量集合
     */
    private Map<String, Class> variable;

    /**
     * 表达式
     */
    private String express;

    /**
     * 返回结果
     */
    private Object result;

    /**
     * 序号
     */
    private Integer orderNum;
}
