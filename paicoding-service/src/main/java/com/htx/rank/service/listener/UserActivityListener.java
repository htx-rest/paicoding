package com.htx.rank.service.listener;

import com.htx.context.ReqInfoContext;
import com.htx.enums.ArticleEventEnum;
import com.htx.event.ArticleMsgEvent;
import com.htx.vo.notify.NotifyMsgEvent;
import com.htx.article.repository.entity.ArticleDO;
import com.htx.comment.repository.entity.CommentDO;
import com.htx.rank.service.UserActivityRankService;
import com.htx.rank.service.model.ActivityScoreBo;
import com.htx.user.repository.entity.UserFootDO;
import com.htx.user.repository.entity.UserRelationDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 微信搜索「二哈学习之路」
 * 用户活跃相关的消息监听器
 * @author htx
 * @date 2024/8/24 16:13
 */
@Component
public class UserActivityListener {
    @Autowired
    private UserActivityRankService userActivityRankService;

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
                userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setRate(true).setArticleId(comment.getArticleId()));
                break;
            case COLLECT:
                UserFootDO foot = (UserFootDO) msgEvent.getContent();
                userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setCollect(true).setArticleId(foot.getDocumentId()));
                break;
            case CANCEL_COLLECT:
                foot = (UserFootDO) msgEvent.getContent();
                userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setCollect(false).setArticleId(foot.getDocumentId()));
                break;
            case PRAISE:
                foot = (UserFootDO) msgEvent.getContent();
                userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setPraise(true).setArticleId(foot.getDocumentId()));
                break;
            case CANCEL_PRAISE:
                foot = (UserFootDO) msgEvent.getContent();
                userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setPraise(false).setArticleId(foot.getDocumentId()));
                break;
            case FOLLOW:
                UserRelationDO relation = (UserRelationDO) msgEvent.getContent();
                userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setFollow(true).setArticleId(relation.getUserId()));
                break;
            case CANCEL_FOLLOW:
                relation = (UserRelationDO) msgEvent.getContent();
                userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setFollow(false).setArticleId(relation.getUserId()));
                break;
            default:
        }
    }

    /**
     * 发布文章，更新对应的积分
     *
     * @param event
     */
    @Async
    @EventListener(ArticleMsgEvent.class)
    public void publishArticleListener(ArticleMsgEvent<ArticleDO> event) {
        ArticleEventEnum type = event.getType();
        if (type == ArticleEventEnum.ONLINE) {
            userActivityRankService.addActivityScore(ReqInfoContext.getReqInfo().getUserId(), new ActivityScoreBo().setPublishArticle(true).setArticleId(event.getContent().getId()));
        }
    }

}
