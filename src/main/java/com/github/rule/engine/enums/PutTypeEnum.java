package com.github.rule.engine.enums;

public enum PutTypeEnum {
    IN("IN"),
    OUT("OUT"),
    INOUT("INOUT")
    ;

    private String value;

    PutTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
