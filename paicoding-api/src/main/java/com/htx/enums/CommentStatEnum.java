package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 评论状态枚举
 * @author htx
 * @date 2024/8/20 22:32
 */
@Getter
public enum CommentStatEnum {

    NOT_COMMENT(0, "未评论"),
    COMMENT(1, "已评论"),
    DELETE_COMMENT(2, "删除评论");

    CommentStatEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static CommentStatEnum formCode(Integer code) {
        for (CommentStatEnum value : CommentStatEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return CommentStatEnum.NOT_COMMENT;
    }
}
