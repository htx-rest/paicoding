package com.htx.enums.column;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 发布状态枚举
 * @author htx
 * @date 2024/8/20 22:22
 */
@Getter
public enum ColumnStatusEnum {

    OFFLINE(0, "未发布"),
    CONTINUE(1, "连载"),
    OVER(2, "已完结");

    ColumnStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final int code;
    private final String desc;

    public static ColumnStatusEnum formCode(int code) {
        for (ColumnStatusEnum status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return ColumnStatusEnum.OFFLINE;
    }
}
