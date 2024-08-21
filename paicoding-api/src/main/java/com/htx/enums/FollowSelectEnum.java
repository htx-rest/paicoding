package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 关注用户枚举
 * @author htx
 * @date 2024/8/20 22:38
 */
@Getter
public enum FollowSelectEnum {

    FOLLOW("follow", "关注列表"),
    FANS("fans", "粉丝列表");

    FollowSelectEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final String code;
    private final String desc;

    public static FollowSelectEnum fromCode(String code) {
        for (FollowSelectEnum value : FollowSelectEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return FollowSelectEnum.FOLLOW;
    }
}
