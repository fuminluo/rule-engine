package com.github.rule.engine.enums;

import com.github.rule.engine.dto.LabelDTO;

import java.util.ArrayList;
import java.util.List;

public enum DBTypeEnum {
    VARCHAR2("NVARCHAR2", "字符串"),
    NUMBER("NUMBER", "数字"),
    DATE("DATE", "时间");

    DBTypeEnum(String value, String label) {
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

    public static List getEnumLabelValues() {
        List<LabelDTO> list = new ArrayList<>();
        for (DBTypeEnum dbTypeEnum : DBTypeEnum.values()) {
            list.add(new LabelDTO(dbTypeEnum.getValue(), dbTypeEnum.getLabel()));
        }
        return list;
    }
}
