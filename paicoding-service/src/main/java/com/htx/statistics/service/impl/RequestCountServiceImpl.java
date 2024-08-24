package com.htx.statistics.service.impl;

import com.htx.vo.statistics.dto.StatisticsDayDTO;
import com.htx.statistics.repository.dao.RequestCountDao;
import com.htx.statistics.repository.entity.RequestCountDO;
import com.htx.statistics.service.RequestCountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 16:05
 */
@Slf4j
@Service
public class RequestCountServiceImpl implements RequestCountService {
    @Autowired
    private RequestCountDao requestCountDao;

    @Override
    public RequestCountDO getRequestCount(String host) {
        return requestCountDao.getRequestCount(host, Date.valueOf(LocalDate.now()));
    }

    @Override
    public void insert(String host) {
        RequestCountDO requestCountDO = null;
        try {
            requestCountDO = new RequestCountDO();
            requestCountDO.setHost(host);
            requestCountDO.setCnt(1);
            requestCountDO.setDate(Date.valueOf(LocalDate.now()));
            requestCountDao.save(requestCountDO);
        } catch (Exception e) {
            // fixme 非数据库原因得异常，则大概率是0点的并发访问，导致同一天写入多条数据的问题； 可以考虑使用分布式锁来避免
            // todo 后续考虑使用redis自增来实现pv计数统计
            log.error("save requestCount error: {}", requestCountDO, e);
        }
    }

    @Override
    public void incrementCount(Long id) {
        requestCountDao.incrementCount(id);
    }

    @Override
    public Long getPvTotalCount() {
        return requestCountDao.getPvTotalCount();
    }

    @Override
    public List<StatisticsDayDTO> getPvUvDayList(Integer day) {
        return requestCountDao.getPvUvDayList(day);
    }

}
