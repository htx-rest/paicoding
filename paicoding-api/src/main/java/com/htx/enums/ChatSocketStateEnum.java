package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 22:30
 */
@Getter
public enum ChatSocketStateEnum {
    // code desc
    // 连接成功
    Established(0, "Established"),
    // payload 消息
    Payload(1, "Payload"),
    // Closed 关闭
    Closed(2, "Closed"),
    ;

    private final Integer code;
    private final String desc;

    ChatSocketStateEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ChatSocketStateEnum typeOf(int type) {
        for (ChatSocketStateEnum value : ChatSocketStateEnum.values()) {
            if (value.code.equals(type)) {
                return value;
            }
        }
        return null;
    }

    public static ChatSocketStateEnum typeOf(String type) {
        return valueOf(type.toUpperCase().trim());
    }


}