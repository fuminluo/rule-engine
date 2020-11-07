package com.github.rule.engine.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LuoFuMin
 * @DATE 2020/11/3 11:10
 */
public class Test {
    public static void main(String[] args) {
        Map map = new HashMap<>();

        map.computeIfAbsent("", k -> k + "");
    }
}
