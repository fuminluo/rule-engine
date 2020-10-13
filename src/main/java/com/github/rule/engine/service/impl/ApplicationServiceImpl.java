package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.mapper.ApplicationMapper;
import com.github.rule.engine.dto.ApplicationTreeView;
import com.github.rule.engine.entity.Application;
import com.github.rule.engine.service.ApplicationService;
import com.github.rule.engine.utils.TreeNodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用表(TApplication)表服务实现类
 *
 * @author makejava
 * @since 2020-10-08 19:04:43
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public R<List<ApplicationTreeView>> findTree() {
        List<ApplicationTreeView> treeList = applicationMapper.findTree();
        return R.ok(TreeNodeUtils.bulid(treeList, TreeNodeUtils.PARENT));
    }
}