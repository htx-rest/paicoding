package com.htx.statistics.repository.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.vo.statistics.dto.StatisticsDayDTO;
import com.htx.statistics.repository.entity.RequestCountDO;
import com.htx.statistics.repository.mapper.RequestCountMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 请求计数
 * @author htx
 * @date 2024/8/24 15:59
 */
@Repository
public class RequestCountDao extends ServiceImpl<RequestCountMapper, RequestCountDO> {

    public Long getPvTotalCount() {
        return baseMapper.getPvTotalCount();
    }

    /**
     * 获取请求数据
     *
     * @param host
     * @param date
     * @return
     */
    public RequestCountDO getRequestCount(String host, Date date) {
        return lambdaQuery()
                .eq(RequestCountDO::getHost, host)
                .eq(RequestCountDO::getDate, date)
                .one();
    }

    /**
     * 获取 PV UV 数据列表
     * @param day
     * @return
     */
    public List<StatisticsDayDTO> getPvUvDayList(Integer day) {
        return baseMapper.getPvUvDayList(day);
    }


    public void incrementCount(Long id) {
        baseMapper.incrementCount(id);
    }
}
