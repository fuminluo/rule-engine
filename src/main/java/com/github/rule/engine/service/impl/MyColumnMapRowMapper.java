package com.github.rule.engine.service.impl;

import com.github.rule.engine.service.CustomRowHandler;
import com.github.rule.engine.utils.StrUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/7 20:14
 */
public class MyColumnMapRowMapper<T> implements RowMapper<Map<String, Object>> {

    private CustomRowHandler customRowHandler;

    public MyColumnMapRowMapper(CustomRowHandler customRowHandler) {
        this.customRowHandler = customRowHandler;
    }

    public CustomRowHandler getCustomRowHandler() {
        return customRowHandler;
    }

    public void setCustomRowHandler(CustomRowHandler customRowHandler) {
        this.customRowHandler = customRowHandler;
    }


    @Override
    public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        Map<String, Object> mapOfColumnValues = this.createColumnMap(columnCount);
        for (int i = 1; i <= columnCount; ++i) {
            String column = JdbcUtils.lookupColumnName(rsmd, i);
            String columnKey = this.getColumnKey(column);
            Object columnValue = this.getColumnValue(rs, i);
            //默认开启下划线转驼峰
            columnKey = StrUtils.lineToHump(columnKey);
            //自定义数据处理
            if (null != customRowHandler) {
                customRowHandler.customRowHandler(mapOfColumnValues, columnKey, columnValue);
            }
            mapOfColumnValues.putIfAbsent(columnKey, columnValue);
        }
        return mapOfColumnValues;
    }

    protected Map<String, Object> createColumnMap(int columnCount) {
        return new LinkedCaseInsensitiveMap(columnCount);
    }

    protected String getColumnKey(String columnName) {
        return columnName;
    }

    @Nullable
    protected Object getColumnValue(ResultSet rs, int index) throws SQLException {
        Object object = JdbcUtils.getResultSetValue(rs, index);
        if (null != object) {
            if ("java.sql.Timestamp".equals(object.getClass().getName())) {
                return object.toString();
            }
        }
        return object;
    }
}
