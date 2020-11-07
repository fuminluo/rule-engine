package com.github.rule.engine.enums;

import com.github.rule.engine.dto.LabelDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */

public enum DataTypeEnum {
    STRING("String","字符串"),
    NUMBER("Number","数字"),
    DATE("Date","时间");

    DataTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

    private String value;

    private String label;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public static List getEnumValues() {
        List<String> list = new ArrayList<>();
        for (DataTypeEnum dataTypeEnum : DataTypeEnum.values()) {
            list.add(dataTypeEnum.getValue());
        }
        return list;
    }

    public static List getEnumLabelValues() {
        List<LabelDTO> list = new ArrayList<>();
        for (DataTypeEnum dataTypeEnum : DataTypeEnum.values()) {
            list.add(new LabelDTO(dataTypeEnum.getValue(), dataTypeEnum.getLabel()));
        }
        return list;
    }
}
