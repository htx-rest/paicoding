package com.htx.enums.rank;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 活跃排行榜时间周期
 * @author htx
 * @date 2024/8/20 22:24
 */
@AllArgsConstructor
@Getter
public enum ActivityRankTimeEnum {
    DAY(1, "day"),
    MONTH(2, "month"),
    ;

    private int type;
    private String desc;

    public static ActivityRankTimeEnum nameOf(String name) {
        if (DAY.desc.equalsIgnoreCase(name)) {
            return DAY;
        } else if (MONTH.desc.equalsIgnoreCase(name)) {
            return MONTH;
        }
        return null;
    }
}
