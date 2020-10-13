package com.github.rule.engine.dto;

import com.github.rule.engine.base.BaseTreeNode;
import lombok.Data;

/**
 * @Author admin
 * @DATE 2020/10/9 9:44
 */
@Data
public class ApplicationTreeView extends BaseTreeNode {

    /**
     * 应用名称
     */
    private String label;

    /**
     * 应用编码
     */
    private String value;
}
