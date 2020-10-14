package com.github.rule.engine.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ApplicationTableDTO implements Serializable {

    private static final long serialVersionUID = 1L;

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
     * 是否为叶子节点：1-是；0-否；
     */
    private Integer isLeaf;

    /**
     * 根名称
     */
    private String rootName;

    /**
     * 备注
     */
    private String remarks;
    /**
     * 时间戳
     */
    private LocalDate dateTime;
}
