package com.github.rule.engine.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author admin
 * @DATE 2020/10/13 15:33
 */
@Data
public class OptionDTO implements Serializable {
    private static final long serialVersionUID = 9091867038851782279L;
    /**
     * key
     */
    private String value;

    private String label;
}
