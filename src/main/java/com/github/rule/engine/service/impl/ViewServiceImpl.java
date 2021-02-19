package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.rule.engine.dto.ApiViewDTO;
import com.github.rule.engine.entity.View;
import com.github.rule.engine.mapper.ViewMapper;
import com.github.rule.engine.service.CustomListHandler;
import com.github.rule.engine.service.CustomRowHandler;
import com.github.rule.engine.service.ViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * 自定义视图(TView)表服务实现类
 *
 * @author makejava
 * @since 2021-02-07 17:27:06
 */
@Service
public class ViewServiceImpl implements ViewService {
    @Autowired
    private ViewMapper viewMapper;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Object findData(ApiViewDTO apiViewDTO) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        LambdaQueryWrapper<View> wrapper = new LambdaQueryWrapper();
        wrapper.eq(View::getViewCode, apiViewDTO.getViewCode());
        View view = viewMapper.selectOne(wrapper);
        /*List<Map<String, Object>> data = jdbcTemplate.queryForList(view.getSqlStr());
        List<Map<String, Object>> data
                = (List<Map<String, Object>>) jdbcTemplate.query(view.getSqlStr(), new RowMapperResultSetExtractor(new ColumnMapRowMapper()));
        */
        //ResultSetExtractor<List<?>> resultSetExtractor = new MyRowMapperResultSetExtractor(rowMapper);
        //数据库读取className
        String className = "com.github.rule.engine.service.impl.DefaultRowHandler";
        Object handler = Class.forName(className).newInstance();

        CustomRowHandler customRowHandler = null;
        CustomListHandler customListHandler = null;

        if (handler instanceof CustomRowHandler) {
            customRowHandler = (CustomRowHandler) handler;
        }
        if (handler instanceof CustomListHandler) {
            customListHandler = (CustomListHandler) handler;
        }

        RowMapper<Map<String, Object>> rowMapper = new MyColumnMapRowMapper(customRowHandler);
        ResultSetExtractor<List<?>> resultSetExtractor = new MyRowMapperResultSetExtractor(rowMapper, customListHandler);

        List<Map<String, Object>> data
                = (List<Map<String, Object>>) jdbcTemplate.query(view.getSqlStr(), resultSetExtractor);

        return data;
    }


}