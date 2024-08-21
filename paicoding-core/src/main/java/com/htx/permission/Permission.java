package com.htx.permission;

import java.lang.annotation.*;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 23:14
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    /**
     * 限定权限
     *
     * @return
     */
    UserRole role() default UserRole.ALL;
}
