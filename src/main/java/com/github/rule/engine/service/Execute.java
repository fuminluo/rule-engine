package com.github.rule.engine.service;

/**
 * @Author admin
 * @DATE 2020/10/12 20:23
 */
public interface Execute<T> {

    void convertToEntity(T t);
}
