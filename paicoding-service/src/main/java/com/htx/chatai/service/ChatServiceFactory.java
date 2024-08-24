package com.htx.chatai.service;

import com.htx.enums.ai.AISourceEnum;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 21:18
 */
@Component
public class ChatServiceFactory {
    private final Map<AISourceEnum, ChatService> chatServiceMap;


    public ChatServiceFactory(List<ChatService> chatServiceList) {
        chatServiceMap = Maps.newHashMapWithExpectedSize(chatServiceList.size());
        for (ChatService chatService : chatServiceList) {
            chatServiceMap.put(chatService.source(), chatService);
        }
    }

    public ChatService getChatService(AISourceEnum aiSource) {
        return chatServiceMap.get(aiSource);
    }
}
