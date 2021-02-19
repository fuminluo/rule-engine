package com.github.rule.engine.service;

import java.util.List;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/18 17:44
 */
public interface CustomListHandler<T> {

    List<T> customListHandler(List<T> results);
}
