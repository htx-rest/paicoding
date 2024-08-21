package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 关注类型枚举
 * @author htx
 * @date 2024/8/20 22:39
 */
@Getter
public enum FollowTypeEnum {

    FOLLOW("follow", "我关注的用户"),
    FANS("fans", "关注我的粉丝");

    FollowTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final String code;
    private final String desc;

    public static FollowTypeEnum formCode(String code) {
        for (FollowTypeEnum value : FollowTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return FollowTypeEnum.FOLLOW;
    }
}
