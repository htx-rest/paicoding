package com.htx.statistics.listener;

import com.htx.enums.ArticleEventEnum;
import com.htx.event.ArticleMsgEvent;
import com.htx.vo.notify.NotifyMsgEvent;
import com.htx.cache.RedisClient;
import com.htx.article.repository.dao.ArticleDao;
import com.htx.article.repository.entity.ArticleDO;
import com.htx.comment.repository.entity.CommentDO;
import com.htx.user.repository.entity.UserFootDO;
import com.htx.user.repository.entity.UserRelationDO;
import com.htx.statistics.constants.CountConstants;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 微信搜索「二哈学习之路」
 * 用户活跃相关的消息监听器
 * @author htx
 * @date 2024/8/24 15:56
 */
@Component
public class UserStatisticEventListener {
    @Resource
    private ArticleDao articleDao;

    /**
     * 用户操作行为，增加对应的积分
     *
     * @param msgEvent
     */
    @EventListener(classes = NotifyMsgEvent.class)
    @Async
    public void notifyMsgListener(NotifyMsgEvent msgEvent) {
        switch (msgEvent.getNotifyType()) {
            case COMMENT:
            case REPLY:
                CommentDO comment = (CommentDO) msgEvent.getContent();
                RedisClient.hIncr(CountConstants.ARTICLE_STATISTIC_INFO + comment.getArticleId(), CountConstants.COMMENT_COUNT, 1);
                break;
            case DELETE_COMMENT:
            case DELETE_REPLY:
                comment = (CommentDO) msgEvent.getContent();
                RedisClient.hIncr(CountConstants.ARTICLE_STATISTIC_INFO + comment.getArticleId(), CountConstants.COMMENT_COUNT, -1);
                break;
            case COLLECT:
                UserFootDO foot = (UserFootDO) msgEvent.getContent();
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + foot.getDocumentUserId(), CountConstants.COLLECTION_COUNT, 1);
                RedisClient.hIncr(CountConstants.ARTICLE_STATISTIC_INFO + foot.getDocumentId(), CountConstants.COLLECTION_COUNT, 1);
                break;
            case CANCEL_COLLECT:
                foot = (UserFootDO) msgEvent.getContent();
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + foot.getDocumentUserId(), CountConstants.COLLECTION_COUNT, -1);
                RedisClient.hIncr(CountConstants.ARTICLE_STATISTIC_INFO + foot.getDocumentId(), CountConstants.COLLECTION_COUNT, -1);
                break;
            case PRAISE:
                foot = (UserFootDO) msgEvent.getContent();
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + foot.getDocumentUserId(), CountConstants.PRAISE_COUNT, 1);
                RedisClient.hIncr(CountConstants.ARTICLE_STATISTIC_INFO + foot.getDocumentId(), CountConstants.PRAISE_COUNT, 1);
                break;
            case CANCEL_PRAISE:
                foot = (UserFootDO) msgEvent.getContent();
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + foot.getDocumentUserId(), CountConstants.PRAISE_COUNT, -1);
                RedisClient.hIncr(CountConstants.ARTICLE_STATISTIC_INFO + foot.getDocumentId(), CountConstants.PRAISE_COUNT, -1);
                break;
            case FOLLOW:
                UserRelationDO relation = (UserRelationDO) msgEvent.getContent();
                // 主用户粉丝数 + 1
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + relation.getUserId(), CountConstants.FANS_COUNT, 1);
                // 粉丝的关注数 + 1
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + relation.getFollowUserId(), CountConstants.FOLLOW_COUNT, 1);
                break;
            case CANCEL_FOLLOW:
                relation = (UserRelationDO) msgEvent.getContent();
                // 主用户粉丝数 + 1
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + relation.getUserId(), CountConstants.FANS_COUNT, -1);
                // 粉丝的关注数 + 1
                RedisClient.hIncr(CountConstants.USER_STATISTIC_INFO + relation.getFollowUserId(), CountConstants.FOLLOW_COUNT, -1);
                break;
            default:
        }
    }

    /**
     * 发布文章，更新对应的文章计数
     *
     * @param event
     */
    @Async
    @EventListener(ArticleMsgEvent.class)
    public void publishArticleListener(ArticleMsgEvent<ArticleDO> event) {
        ArticleEventEnum type = event.getType();
        if (type == ArticleEventEnum.ONLINE || type == ArticleEventEnum.OFFLINE || type == ArticleEventEnum.DELETE) {
            Long userId = event.getContent().getUserId();
            int count = articleDao.countArticleByUser(userId);
            RedisClient.hSet(CountConstants.USER_STATISTIC_INFO + userId, CountConstants.ARTICLE_COUNT, count);
        }
    }
}
