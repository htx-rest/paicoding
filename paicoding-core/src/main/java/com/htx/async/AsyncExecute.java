package com.htx.async;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 微信搜索「二哈学习之路」
 * 异步执行
 * @author htx
 * @date 2024/8/21 21:46
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AsyncExecute {
    /**
     * 是否开启异步执行
     *
     * @return
     */
    boolean value() default true;

    /**
     * 超时时间，默认3s
     *
     * @return
     */
    int timeOut() default 3;

    /**
     * 超时时间单位，默认秒，配合上面的 timeOut 使用
     *
     * @return
     */
    TimeUnit unit() default TimeUnit.SECONDS;

    /**
     * 当出现超时返回的兜底逻辑,支持SpEL
     * 如果返回的是空字符串，则表示抛出异常
     *
     * @return
     */
    String timeOutRsp() default "";
}
