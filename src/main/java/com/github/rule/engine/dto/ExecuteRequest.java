package com.github.rule.engine.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Map;

/**
 * @Author admin
 * @DATE 2020/10/10 18:49
 */
@Data
public class ExecuteRequest implements Serializable {

    private static final long serialVersionUID = -8231003767476935617L;

    @NotBlank
    private String applicationCode;

    private Map<String, Object> param;
}
