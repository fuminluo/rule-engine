package com.github.rule.engine.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Admin
 * @DATE 2020/10/13 15:22
 */
@Data
public class ValueSetRequest implements Serializable {

    private static final long serialVersionUID = 7464330201140722868L;

    private String segmentCode;

    private String applicationId;

    private String valueParentCode;
}
