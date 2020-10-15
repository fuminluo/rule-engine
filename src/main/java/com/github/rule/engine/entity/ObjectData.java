package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * (TStringData)表实体类
 *
 * @author makejava
 * @since 2020-10-08 19:06:56
 */
@Data
@ToString
@EqualsAndHashCode
@SuppressWarnings("serial")
@TableName(value = "t_object_data")
public class ObjectData extends Model<ObjectData> {

    private String id;

    private String hashCode;

    private String applicationId;

    private LocalDateTime dateTime;

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

    private LocalDateTime columnDate1;

    private LocalDateTime columnDate2;

    private LocalDateTime columnDate3;

    private LocalDateTime columnDate4;


}