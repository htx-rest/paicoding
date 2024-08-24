package com.htx.notify.service;

import com.htx.enums.NotifyTypeEnum;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.notify.dto.NotifyMsgDTO;
import com.htx.user.repository.entity.UserFootDO;

import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 21:08
 */
public interface NotifyService {

    /**
     * 查询用户未读消息数量
     *
     * @param userId
     * @return
     */
    int queryUserNotifyMsgCount(Long userId);

    /**
     * 查询通知列表
     *
     * @param userId
     * @param type
     * @param page
     * @return
     */
    PageListVo<NotifyMsgDTO> queryUserNotices(Long userId, NotifyTypeEnum type, PageParam page);

    /**
     * 查询未读消息数
     * @param userId
     * @return
     */
    Map<String, Integer> queryUnreadCounts(long userId);

    /**
     * 保存通知
     *
     * @param foot
     * @param notifyTypeEnum
     */
    void saveArticleNotify(UserFootDO foot, NotifyTypeEnum notifyTypeEnum);
}
