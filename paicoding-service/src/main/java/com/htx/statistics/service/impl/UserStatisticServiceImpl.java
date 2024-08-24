package com.htx.statistics.service.impl;

import com.htx.statistics.service.UserStatisticService;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 微信搜索「二哈学习之路」
 * 用户统计服务
 * @author htx
 * @date 2024/8/24 16:07
 */
@Service
public class UserStatisticServiceImpl implements UserStatisticService {

    /**
     * 对于单机的场景，可以直接使用本地局部变量来实现计数
     * 对于集群的场景，可考虑借助 redis的zset 来实现集群的在线用户人数统计
     */
    private AtomicInteger onlineUserCnt = new AtomicInteger(0);

    /**
     * 添加在线人数
     *
     * @param add 正数，表示添加在线人数；负数，表示减少在线人数
     * @return
     */
    @Override
    public int incrOnlineUserCnt(int add) {
        return onlineUserCnt.addAndGet(add);
    }

    /**
     * 查询在线用户人数
     *
     * @return
     */
    @Override
    public int getOnlineUserCnt() {
        return onlineUserCnt.get();
    }

}
