package com.github.rule.engine.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author admin
 * @DATE 2020/10/9 9:54
 */
@Data
public class ApplicationDTO implements Serializable {

    private static final long serialVersionUID = 3208289520711560398L;

    /**
     * 应用id
     */
    private String id;

    /**
     * 应用名称
     */
    private String label;

    /**
     * 应用编码
     */
    private String value;
}
