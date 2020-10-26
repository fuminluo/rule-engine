package com.github.rule.engine.enums;

public enum DBTypeEnum {
    VARCHAR2("NVARCHAR2"),
    NUMBER("NUMBER"),
    DATE("DATE");

    DBTypeEnum(String value) {
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
