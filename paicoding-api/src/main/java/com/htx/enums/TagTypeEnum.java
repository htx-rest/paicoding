package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 标签类型枚举
 * @author htx
 * @date 2024/8/20 22:49
 */
@Getter
public enum TagTypeEnum {

    SYSTEM_TAG(1, "系统标签"),
    CUSTOM_TAG(2, "已读");

    TagTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static TagTypeEnum formCode(Integer code) {
        for (TagTypeEnum value : TagTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return TagTypeEnum.SYSTEM_TAG;
    }
}
