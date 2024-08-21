package com.htx.vo.statistics.dto;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 每天的统计计数
 * @author htx
 * @date 2024/8/21 20:44
 */
@Data
public class StatisticsDayDTO {

    /**
     * 日期
     */
    private String date;

    /**
     * 数量
     */
    private Long pvCount;

    /**
     * UV数量
     */
    private Long uvCount;
}
