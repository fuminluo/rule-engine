package com.github.rule.engine.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/7 17:17
 */
@Data
public class ApiViewDTO implements Serializable {

    private static final long serialVersionUID = -1978749595029464079L;

    private String viewCode;

    private QueryParam queryParam;


}

@Data
class QueryParam {

    /**
     * 字段名
     */
    private String item;

    /**
     * 数据类型
     */
    private String datatype;

    /**
     * 操作符
     */
    private String operator;

    /**
     * 传入值
     */
    private String value;

    /**
     * 最小值
     */
    private String minValue;
    /**
     * 最大值
     */
    private String maxValue;
}