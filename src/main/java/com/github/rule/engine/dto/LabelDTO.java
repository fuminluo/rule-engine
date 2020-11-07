package com.github.rule.engine.dto;

import lombok.Data;

/**
 * @Author LuoFuMin
 * @DATE 2020/11/5 17:22
 */
@Data
public class LabelDTO {

    private String value;

    private String label;

    public LabelDTO(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
