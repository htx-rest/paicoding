package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 文档来源枚举
 * @author htx
 * @date 2024/8/20 22:48
 */
@Getter
public enum SourceTypeEnum {

    EMPTY(0, ""),
    REPRINT(1, "转载"),
    ORIGINAL(2, "原创"),
    TRANSLATION(3, "翻译");

    SourceTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static SourceTypeEnum formCode(Integer code) {
        for (SourceTypeEnum value : SourceTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return SourceTypeEnum.EMPTY;
    }
}
