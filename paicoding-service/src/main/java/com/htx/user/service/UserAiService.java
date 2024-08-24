package com.htx.user.service;

import com.htx.enums.ai.AISourceEnum;
import com.htx.vo.chat.ChatItemVo;
import com.htx.vo.user.UserPwdLoginReq;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 15:25
 */
public interface UserAiService {
    /**
     * 保存聊天历史记录
     *
     * @param source
     * @param user
     * @param item
     */
    void pushChatItem(AISourceEnum source, Long user, ChatItemVo item);

    /**
     * 获取用户的最大聊天次数
     *
     * @param userId
     * @return
     */
    int getMaxChatCnt(Long userId);

    /**
     * 重建用户绑定的星球编号
     *
     * @param loginReq
     */

    void initOrUpdateAiInfo(UserPwdLoginReq loginReq);
}
