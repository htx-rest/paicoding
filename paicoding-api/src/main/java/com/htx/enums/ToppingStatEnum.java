package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 置顶状态枚举
 * @author htx
 * @date 2024/8/20 22:49
 */
@Getter
public enum ToppingStatEnum {

    NOT_TOPPING(0, "不置顶"),
    TOPPING(1, "置顶");

    ToppingStatEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static ToppingStatEnum formCode(Integer code) {
        for (ToppingStatEnum value : ToppingStatEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return ToppingStatEnum.NOT_TOPPING;
    }
}
