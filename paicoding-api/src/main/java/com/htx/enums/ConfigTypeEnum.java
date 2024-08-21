package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 配置类型枚举
 * @author htx
 * @date 2024/8/20 22:34
 */
@Getter
public enum ConfigTypeEnum {

    EMPTY(0, ""),
    HOME_PAGE(1, "首页Banner"),
    SIDE_PAGE(2, "侧边Banner"),
    ADVERTISEMENT(3, "广告Banner"),
    NOTICE(4, "公告"),
    COLUMN(5, "教程"),
    PDF(6, "电子书");

    ConfigTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private final Integer code;
    private final String desc;

    public static ConfigTypeEnum formCode(Integer code) {
        for (ConfigTypeEnum value : ConfigTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return ConfigTypeEnum.EMPTY;
    }
}
