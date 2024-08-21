package com.htx.mdc;

import java.lang.annotation.*;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 23:10
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MdcDot {
    String bizCode() default "";
}
