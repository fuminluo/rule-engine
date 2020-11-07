package com.github.rule.engine.enums;

import com.github.rule.engine.dto.LabelDTO;

import java.util.ArrayList;
import java.util.List;

public enum PutTypeEnum {
    IN("IN", "输入"),
    OUT("OUT", "输出"),
    INOUT("INOUT", "输入输出");

    private String value;
    private String label;


    PutTypeEnum(String value, String label) {
        this.value = value;
        this.label = label;
    }

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
        for (PutTypeEnum putTypeEnum : PutTypeEnum.values()) {
            list.add(putTypeEnum.getValue());
        }
        return list;
    }

    public static List getEnumLabelValues() {
        List<LabelDTO> list = new ArrayList<>();
        for (PutTypeEnum putTypeEnum : PutTypeEnum.values()) {
            list.add(new LabelDTO(putTypeEnum.getValue(), putTypeEnum.getLabel()));
        }
        return list;
    }
}
