package com.htx.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 22:47
 */
public enum RoleEnum {
    NORMAL(0, "普通用户"),
    ADMIN(1, "超级用户"),
    ;

    @Getter
    private int role;
    @Getter
    private String desc;

    RoleEnum(int role, String desc) {
        this.role = role;
        this.desc = desc;
    }

    public static String role(Integer roleId) {
        if (Objects.equals(roleId, 1)) {
            return ADMIN.name();
        } else {
            return NORMAL.name();
        }
    }
}
