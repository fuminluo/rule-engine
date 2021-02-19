package com.github.rule.engine.service;

import java.sql.SQLException;
import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/8 9:45
 */
public interface CustomRowHandler {

    void customRowHandler(Map<String, Object> var1, String columnKey, Object columnValue) throws SQLException;
}
