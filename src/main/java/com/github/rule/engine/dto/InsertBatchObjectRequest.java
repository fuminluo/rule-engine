package com.github.rule.engine.dto;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Author Admin
 * @DATE 2020/10/14 10:44
 */
@Data
@ToString
public class InsertBatchObjectRequest implements Serializable {

    private static final long serialVersionUID = 6920333275394793736L;

    private String applicationId;

    private List<String> columnChar1;

    private List<String> columnChar2;

    private List<String> columnChar3;

    private List<String> columnChar4;

    private List<String> columnChar5;

    private List<String> columnChar6;

    private List<String> columnChar7;

    private List<String> columnChar8;

    private List<String> columnChar9;

    private List<String> columnChar10;

    private List<String> columnChar11;

    private List<String> columnChar12;

    private List<String> columnChar13;

    private List<String> columnChar14;

    private List<String> columnChar15;

    private List<BigDecimal> columnNumber1;

    private List<BigDecimal> columnNumber2;

    private List<BigDecimal> columnNumber3;

    private List<BigDecimal> columnNumber4;

    private List<BigDecimal> columnNumber5;

    private List<BigDecimal> columnNumber6;

    private List<String> columnDate1;

    private List<String> columnDate2;

    private List<String> columnDate3;

    private List<String> columnDate4;

}
