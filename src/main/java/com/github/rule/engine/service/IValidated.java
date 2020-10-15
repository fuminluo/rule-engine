package com.github.rule.engine.service;

/**
 * 校验接口
 *
 * @Author Admin
 * @DATE 2020/10/15 17:01
 */
public interface IValidated {

    void doValid(String applicationId, Long batchGroupId);
}
