package com.github.rule.engine.utils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author LuoFuMin
 * @DATE 2020/11/3 11:10
 */
public class Test {
    private static List list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        List<? extends Number> foo3 = new ArrayList<Number>();  // Number "extends" Number (in this context)
        List<? extends Number> foo4 = new ArrayList<Integer>(); // Integer extends Number
        List<? extends Number> foo5 = new ArrayList<Double>();  // Double extends Number
    }
    static class A{}
    static class B extends A{}
}
