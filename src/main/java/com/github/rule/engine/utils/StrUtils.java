package com.github.rule.engine.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author LuoFuMin
 * @DATE 2021/2/19 9:28
 */
public class StrUtils {

    private static final Pattern linePattern = Pattern.compile("_(\\w)");

    private static final Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线转驼峰
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        String humpToLine = humpToLine("isD");
        System.out.println(humpToLine);// fParentNoLeader
    }
}
