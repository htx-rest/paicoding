package com.htx.statistics.service.impl;

import com.htx.vo.statistics.dto.StatisticsCountDTO;
import com.htx.vo.statistics.dto.StatisticsDayDTO;
import com.htx.vo.user.dto.UserFootStatisticDTO;
import com.htx.article.service.ArticleReadService;
import com.htx.article.service.ColumnService;
import com.htx.statistics.repository.entity.RequestCountDO;
import com.htx.statistics.service.RequestCountService;
import com.htx.statistics.service.StatisticsSettingService;
import com.htx.user.service.UserFootService;
import com.htx.user.service.UserService;
import com.htx.user.service.conf.AiConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 数据统计后台接口
 * @author htx
 * @date 2024/8/24 16:06
 */
@Slf4j
@Service
public class StatisticsSettingServiceImpl implements StatisticsSettingService {

    @Autowired
    private RequestCountService requestCountService;

    @Autowired
    private UserService userService;

    @Autowired
    private ColumnService columnService;

    @Autowired
    private UserFootService userFootService;

    @Autowired
    private ArticleReadService articleReadService;

    @Resource
    private AiConfig aiConfig;

    @Override
    public void saveRequestCount(String host) {
        RequestCountDO requestCountDO = requestCountService.getRequestCount(host);
        if (requestCountDO == null) {
            requestCountService.insert(host);
        } else {
            // 改为数据库直接更新
            requestCountService.incrementCount(requestCountDO.getId());
        }
    }

    @Override
    public StatisticsCountDTO getStatisticsCount() {
        // 从 user_foot 表中查询点赞数、收藏数、留言数、阅读数
        UserFootStatisticDTO userFootStatisticDTO =  userFootService.getFootCount();
        if (userFootStatisticDTO == null) {
            userFootStatisticDTO = new UserFootStatisticDTO();
        }
        return StatisticsCountDTO.builder()
                .userCount(userService.getUserCount())
                .articleCount(articleReadService.getArticleCount())
                .pvCount(requestCountService.getPvTotalCount())
                .tutorialCount(columnService.getTutorialCount())
                .commentCount(userFootStatisticDTO.getCommentCount())
                .collectCount(userFootStatisticDTO.getCollectionCount())
                .likeCount(userFootStatisticDTO.getPraiseCount())
                .readCount(userFootStatisticDTO.getReadCount())
                .starPayCount(aiConfig.getMaxNum().getStarNumber())
                .build();
    }

    @Override
    public List<StatisticsDayDTO> getPvUvDayList(Integer day) {
        return requestCountService.getPvUvDayList(day);
    }

}
