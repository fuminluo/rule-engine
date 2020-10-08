package com.github.rule.engine.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.rule.engine.dao.ApplicationDao;
import com.github.rule.engine.entity.Application;
import com.github.rule.engine.service.ApplicationService;
import org.springframework.stereotype.Service;

/**
 * 应用表(TApplication)表服务实现类
 *
 * @author makejava
 * @since 2020-10-08 19:04:43
 */
@Service("tApplicationService")
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, Application> implements ApplicationService {

}