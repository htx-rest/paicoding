package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 官方状态枚举
 * @author htx
 * @date 2024/8/20 22:42
 */
@Getter
public enum OfficalStatEnum {

    NOT_OFFICAL(0, "非官方"),
    OFFICAL(1, "官方");

    OfficalStatEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static OfficalStatEnum formCode(Integer code) {
        for (OfficalStatEnum value : OfficalStatEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return OfficalStatEnum.NOT_OFFICAL;
    }
}
