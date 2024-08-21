package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 文章类型枚举
 * @author htx
 * @date 2024/8/20 22:28
 */
@Getter
public enum ArticleTypeEnum {

    EMPTY(0, ""),
    BLOG(1, "博文"),
    ANSWER(2, "问答"),
    COLUMN(3, "专栏文章"),
    ;

    ArticleTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static ArticleTypeEnum formCode(Integer code) {
        for (ArticleTypeEnum value : ArticleTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return ArticleTypeEnum.EMPTY;
    }
}
