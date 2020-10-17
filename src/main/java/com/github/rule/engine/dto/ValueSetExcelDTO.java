package com.github.rule.engine.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.github.rule.engine.enums.DataTypeEnum;
import lombok.ToString;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author Admin
 * @DATE 2020/10/16 16:57
 */
@ToString
public class ValueSetExcelDTO implements Serializable {

    private static final long serialVersionUID = 5866923678125016439L;

    /**
     * 应用id
     */
    private String applicationId;

    /**
     * 段值名称
     */
    private String segmentName;

    /**
     * 段值编码
     */
    private String segmentCode;

    /**
     * 值编码
     */
    @Excel(name = "值编码", orderNum = "0")
    @NotBlank(message = "不能为空")
    private String valueCode;

    /**
     * 值名称
     */
    @Excel(name = "值名称", orderNum = "1")
    @NotBlank(message = "不能为空")
    private String valueName;

    /**
     * 数据类型:1-String,2-Number,3-Date
     */
    @Excel(name = "数据类型", orderNum = "2")
    private String dataType;

    /**
     * 备注
     */
    @Excel(name = "备注", orderNum = "3")
    private String remarks;

    /**
     * 值编码父code,用于构建树
     */
    @Excel(name = "父值编码", orderNum = "4")
    private String valueParentCode;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public String getSegmentCode() {
        return segmentCode;
    }

    public void setSegmentCode(String segmentCode) {
        this.segmentCode = segmentCode;
    }

    public String getValueCode() {
        return valueCode;
    }

    public void setValueCode(String valueCode) {
        this.valueCode = valueCode.trim();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName.trim();
    }

    public String getDataType() {
        if (StringUtils.isEmpty(dataType)) {
            return DataTypeEnum.STRING.getValue();
        }
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getValueParentCode() {
        return valueParentCode;
    }

    public void setValueParentCode(String valueParentCode) {
        this.valueParentCode = valueParentCode;
    }
}
