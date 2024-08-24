package com.htx.chatai.service;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 21:17
 */
public interface ChatgptService {

    /**
     * 判断是否在会话中
     *
     * @param wxUuid
     * @return
     */
    boolean inChat(String wxUuid, String content);

    /**
     * 开始进入聊天
     *
     * @param content 输入的内容
     * @return chatgpt返回的结果
     */
    String chat(String wxUuid, String content);

}
