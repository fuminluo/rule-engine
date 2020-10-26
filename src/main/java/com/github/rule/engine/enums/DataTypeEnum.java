package com.github.rule.engine.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Admin
 */

public enum DataTypeEnum {
    STRING("String"),
    NUMBER("Number"),
    DATE("Date");

    DataTypeEnum(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static List getEnumValues() {
        List<String> list = new ArrayList<>();
        for (DataTypeEnum dataTypeEnum : DataTypeEnum.values()) {
            list.add(dataTypeEnum.getValue());
        }
        return list;
    }
}
