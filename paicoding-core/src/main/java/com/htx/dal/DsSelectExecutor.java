package com.htx.dal;

import java.util.function.Supplier;

/**
 * 微信搜索「二哈学习之路」
 * 手动指定数据源的用法
 * @author htx
 * @date 2024/8/21 23:07
 */
public class DsSelectExecutor {

    /**
     * 有返回结果
     *
     * @param ds
     * @param supplier
     * @param <T>
     * @return
     */
    public static <T> T submit(DS ds, Supplier<T> supplier) {
        DsContextHolder.set(ds);
        try {
            return supplier.get();
        } finally {
            DsContextHolder.reset();
        }
    }

    /**
     * 无返回结果
     *
     * @param ds
     * @param call
     */
    public static void execute(DS ds, Runnable call) {
        DsContextHolder.set(ds);
        try {
            call.run();
        } finally {
            DsContextHolder.reset();
        }
    }
}
