package com.github.rule.engine.service.impl;

import com.github.rule.engine.service.CustomListHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/7 19:57
 */
@Log4j2
public class MyRowMapperResultSetExtractor<T> implements ResultSetExtractor<List<T>> {

    private RowMapper<T> rowMapper;

    private int rowsExpected;

    private CustomListHandler<T> customListHandler;

    public MyRowMapperResultSetExtractor(RowMapper<T> rowMapper, CustomListHandler<T> customListHandler) {
        this(rowMapper, 0);
        this.customListHandler = customListHandler;
    }

    public MyRowMapperResultSetExtractor(RowMapper<T> rowMapper, int rowsExpected) {
        Assert.notNull(rowMapper, "RowMapper is required");
        this.rowMapper = rowMapper;
        this.rowsExpected = rowsExpected;
    }

    @Override
    public List<T> extractData(ResultSet rs) throws SQLException {
        List<T> results = this.rowsExpected > 0 ? new ArrayList(this.rowsExpected) : new ArrayList();
        int var3 = 0;

        while (rs.next()) {
            results.add(this.rowMapper.mapRow(rs, var3++));
        }
        //对 results 进行处理
        if (null != customListHandler) {
            return customListHandler.customListHandler(results);
        }
        return results;
    }

}
