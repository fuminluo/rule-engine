package org.rule.engine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.rule.engine.dto.ElementDTO;
import org.rule.engine.entity.Dictionary;
import org.rule.engine.mapper.DictionaryMapper;
import org.rule.engine.service.DictionaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.rule.engine.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author work
 * @since 2022-08-15
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;


    @Override
    public Object treeList(ElementDTO elementDTO) {
        LambdaQueryWrapper<Dictionary> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Dictionary::getEleCode, elementDTO.getEleCode());
        queryWrapper.orderByAsc(Dictionary::getSortNo);
        List<Dictionary> list = dictionaryMapper.selectList(queryWrapper);
        List<Dictionary> tree = TreeUtils.buildTree(list, null);
        return tree;
    }
}
