package com.htx.statistics.service;

import com.htx.vo.statistics.dto.StatisticsDayDTO;
import com.htx.statistics.repository.entity.RequestCountDO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 16:02
 */
public interface RequestCountService {
    RequestCountDO getRequestCount(String host);

    void insert(String host);

    void incrementCount(Long id);

    Long getPvTotalCount();

    List<StatisticsDayDTO> getPvUvDayList(Integer day);
}
