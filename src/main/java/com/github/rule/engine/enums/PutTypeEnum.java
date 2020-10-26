package com.github.rule.engine.enums;

import java.util.ArrayList;
import java.util.List;

public enum PutTypeEnum {
    IN("IN"),
    OUT("OUT"),
    INOUT("INOUT");

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


    public static List getEnumValues() {
        List<String> list = new ArrayList<>();
        for (PutTypeEnum putTypeEnum : PutTypeEnum.values()) {
            list.add(putTypeEnum.getValue());
        }
        return list;
    }
}
