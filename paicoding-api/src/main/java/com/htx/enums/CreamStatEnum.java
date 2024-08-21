package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 加精状态枚举
 * @author htx
 * @date 2024/8/20 22:34
 */
@Getter
public enum CreamStatEnum {

    NOT_CREAM(0, "不加精"),
    CREAM(1, "加精");

    CreamStatEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static CreamStatEnum formCode(Integer code) {
        for (CreamStatEnum value : CreamStatEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return CreamStatEnum.NOT_CREAM;
    }
}
