package com.github.rule.engine.enums;

/**
 * @author Admin
 */

public enum DataTypeEnum {
    STRING("String"),
    DATE("Date"),
    NUMBER("Number");

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
}
