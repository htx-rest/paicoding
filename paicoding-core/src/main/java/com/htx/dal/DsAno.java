package com.htx.dal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 22:56
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DsAno {
    /**
     * 启用的数据源，默认主库
     *
     * @return
     */
    MasterSlaveDsEnum value() default MasterSlaveDsEnum.MASTER;

    /**
     * 启用的数据源，如果存在，则优先使用它来替换默认的value
     *
     * @return
     */
    String ds() default "";
}
