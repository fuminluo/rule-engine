package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dao.ObjectDataDao;
import com.github.rule.engine.entity.ObjectData;
import com.github.rule.engine.service.TObjectDataService;
import org.springframework.stereotype.Service;

/**
 * (TObjectData)表服务实现类
 *
 * @author makejava
 * @since 2020-10-08 19:06:57
 */
@Service("tObjectDataService")
public class TObjectDataServiceImpl extends ServiceImpl<ObjectDataDao, ObjectData> implements TObjectDataService {

}