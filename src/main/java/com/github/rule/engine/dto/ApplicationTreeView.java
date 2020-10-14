package com.github.rule.engine.dto;

import com.github.rule.engine.base.BaseTreeNode;
import lombok.Data;

import java.time.LocalDate;

/**
 * @Author admin
 * @DATE 2020/10/9 9:44
 */
@Data
public class ApplicationTreeView extends BaseTreeNode {

    /**
     * 应用id
     */
    private String id;

    /**
     * 父id
     */
    private String parentId;

    /**
     * 应用名称
     */
    private String applicationName;

    /**
     * 应用编码
     */
    private String applicationCode;

    /**
     * 时间
     */
    private LocalDate dateTime;

    /**
     * 状态
     */
    private String status;
}
