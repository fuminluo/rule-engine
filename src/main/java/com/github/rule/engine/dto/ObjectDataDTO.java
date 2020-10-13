package com.github.rule.engine.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author admin
 * @DATE 2020/10/12 9:42
 */
@Data
@ToString
public class ObjectDataDTO implements Serializable {

    private static final long serialVersionUID = -6112853584961609956L;

    private String applicationId;

    private Long hashCode;

    private String columnChar1;

    private String columnChar2;

    private String columnChar3;

    private String columnChar4;

    private String columnChar5;

    private String columnChar6;

    private String columnChar7;

    private String columnChar8;

    private String columnChar9;

    private String columnChar10;

    private String columnChar11;

    private String columnChar12;

    private String columnChar13;

    private String columnChar14;

    private String columnChar15;

    private BigDecimal columnNumber1;

    private BigDecimal columnNumber2;

    private BigDecimal columnNumber3;

    private BigDecimal columnNumber4;

    private BigDecimal columnNumber5;

    private BigDecimal columnNumber6;

    private LocalDate columnDate1;

    private LocalDate columnDate2;

    private LocalDate columnDate3;

    private LocalDate columnDate4;
}
