package com.htx.enums.site;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 站点统计类型枚举
 * @author htx
 * @date 2024/8/20 22:24
 */
@AllArgsConstructor
@Getter
public enum SiteVisitStatisticsEnum {
    PV(1, "浏览量"),
    UV(2, "独立访客"),
    VV(3, "访问次数"),
    ;

    private int type;
    private String desc;
}
