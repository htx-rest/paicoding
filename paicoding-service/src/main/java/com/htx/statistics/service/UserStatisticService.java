package com.htx.statistics.service;

/**
 * 微信搜索「二哈学习之路」
 * 用户统计服务
 * @author htx
 * @date 2024/8/24 16:03
 */
public interface UserStatisticService {
    /**
     * 添加在线人数
     *
     * @param add 正数，表示添加在线人数；负数，表示减少在线人数
     * @return
     */
    int incrOnlineUserCnt(int add);

    /**
     * 查询在线用户人数
     *
     * @return
     */
    int getOnlineUserCnt();

}
