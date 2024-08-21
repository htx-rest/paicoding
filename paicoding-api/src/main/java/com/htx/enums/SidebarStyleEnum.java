package com.htx.enums;

import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 22:48
 */
@Getter
public enum SidebarStyleEnum {

    NOTICE(1),
    ARTICLES(2),
    RECOMMEND(3),
    ABOUT(4),
    COLUMN(5),
    PDF(6),
    SUBSCRIBE(7),
    /**
     * 活跃排行榜
     */
    ACTIVITY_RANK(8);

    private int style;

    SidebarStyleEnum(int style) {
        this.style = style;
    }
}