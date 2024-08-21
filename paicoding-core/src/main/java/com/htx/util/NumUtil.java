package com.htx.util;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 21:29
 */
public class NumUtil {

    public static boolean nullOrZero(Long num) {
        return num == null || num == 0L;
    }

    public static boolean nullOrZero(Integer num) {
        return num == null || num == 0;
    }

    public static boolean upZero(Long num) {
        return num != null && num > 0;
    }

    public static boolean upZero(Integer num) {
        return num != null && num > 0;
    }
}
