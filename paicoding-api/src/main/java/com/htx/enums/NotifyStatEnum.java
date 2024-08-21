package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 22:40
 */
@Getter
public enum NotifyStatEnum {
    UNREAD(0, "未读"),
    READ(1, "已读");


    private int stat;
    private String msg;

    NotifyStatEnum(int type, String msg) {
        this.stat = type;
        this.msg = msg;
    }
}
