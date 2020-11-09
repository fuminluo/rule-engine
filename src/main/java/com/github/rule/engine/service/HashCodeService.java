package com.github.rule.engine.service;

/**
 * hashCode 接口
 *
 * @Author LuoFuMin
 * @DATE 2020/11/9 14:37
 */
public interface HashCodeService<T> {

    /**
     * 获取 hashcode
     *
     * @param obj
     * @return Long
     */
    Long getHashCode(T obj);
}
