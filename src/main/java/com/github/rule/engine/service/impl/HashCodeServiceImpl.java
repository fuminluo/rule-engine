package com.github.rule.engine.service.impl;

import com.github.rule.engine.dto.ObjectDataDTO;
import com.github.rule.engine.mapper.ObjectDataMapper;
import com.github.rule.engine.service.HashCodeService;
import com.github.rule.engine.utils.SpringContextUtils;

/**
 * @Author LuoFuMin
 * @DATE 2020/11/9 14:39
 */

public class HashCodeServiceImpl implements HashCodeService<ObjectDataDTO> {

    ObjectDataMapper objectDataMapper = SpringContextUtils.getBean(ObjectDataMapper.class);

    @Override
    public Long getHashCode(ObjectDataDTO obj) {
        Long hashCode = objectDataMapper.queryHashCode(obj);
        return hashCode;
    }
}
