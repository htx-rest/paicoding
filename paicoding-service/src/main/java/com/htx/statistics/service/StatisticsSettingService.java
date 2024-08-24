package com.htx.statistics.service;

import com.htx.vo.statistics.dto.StatisticsCountDTO;
import com.htx.vo.statistics.dto.StatisticsDayDTO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 数据统计后台接口
 * @author htx
 * @date 2024/8/24 16:03
 */
public interface StatisticsSettingService {

    /**
     * 保存计数
     *
     * @param host
     */
    void saveRequestCount(String host);

    /**
     * 获取总数
     *
     * @return
     */
    StatisticsCountDTO getStatisticsCount();

    /**
     * 获取每天的PV UV统计数据
     *
     * @param day
     * @return
     */
    List<StatisticsDayDTO> getPvUvDayList(Integer day);

}
