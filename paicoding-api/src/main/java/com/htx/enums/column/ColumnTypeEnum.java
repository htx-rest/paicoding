package com.htx.enums.column;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 发布状态枚举
 * @author htx
 * @date 2024/8/20 22:23
 */
@Getter
public enum ColumnTypeEnum {

    FREE(0, "免费"),
    LOGIN(1, "登录阅读"),
    TIME_FREE(2, "限时免费"),
    STAR_READ(3, "星球阅读"),
    ;

    ColumnTypeEnum(int code, String desc) {
        this.type = code;
        this.desc = desc;
    }

    private final int type;
    private final String desc;

    public static ColumnTypeEnum formCode(int code) {
        for (ColumnTypeEnum status : values()) {
            if (status.getType() == code) {
                return status;
            }
        }
        return ColumnTypeEnum.FREE;
    }
}

