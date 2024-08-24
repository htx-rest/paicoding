package com.htx.rank.service;

import com.htx.enums.rank.ActivityRankTimeEnum;
import com.htx.vo.rank.dto.RankItemDTO;
import com.htx.rank.service.model.ActivityScoreBo;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 用户活跃排行榜
 * @author htx
 * @date 2024/8/24 16:11
 */
public interface UserActivityRankService {
    /**
     * 添加活跃分
     *
     * @param userId
     * @param activityScore
     */
    void addActivityScore(Long userId, ActivityScoreBo activityScore);

    /**
     * 查询用户的活跃信息
     *
     * @param userId
     * @param time
     * @return
     */
    RankItemDTO queryRankInfo(Long userId, ActivityRankTimeEnum time);

    /**
     * 查询活跃度排行榜
     *
     * @param time
     * @return
     */
    List<RankItemDTO> queryRankList(ActivityRankTimeEnum time, int size);
}
