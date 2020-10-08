package com.github.rule.engine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * (TStringData)表实体类
 *
 * @author makejava
 * @since 2020-10-08 19:06:56
 */
@Data
@SuppressWarnings("serial")
@TableName(value = "t_object_data")
public class ObjectData extends Model<ObjectData> {

    @TableId(type = IdType.UUID)
    private String id;

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

    private String hashCode;

    private String applicationId;

    private String templateId;

}