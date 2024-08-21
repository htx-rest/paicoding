package com.htx.senstive.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 23:20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface SensitiveField {
    /**
     * 绑定的db中的哪个字段
     *
     * @return
     */
    String bind() default "";

}
