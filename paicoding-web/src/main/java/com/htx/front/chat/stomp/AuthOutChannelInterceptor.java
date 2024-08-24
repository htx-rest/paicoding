package com.htx.front.chat.stomp;

import com.beust.jcommander.internal.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

/**
 * 微信搜索「二哈学习之路」
 * 权限拦截器，消息广播给用户的场景
 * @author htx
 * @date 2024/8/24 23:14
 */
@Slf4j
public class AuthOutChannelInterceptor implements ChannelInterceptor {
    @Override
    public boolean preReceive(MessageChannel channel) {
        log.debug("Outbound preReceive: channel={}", channel);
        return true;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.debug("Outbound preSend: message={}", message);
        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        log.debug("Outbound postSend. message={}", message);
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        log.debug("Outbound postReceive. message={}", message);
        return message;
    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, @Nullable Exception ex) {
        log.debug("Outbound afterSendCompletion. message={}", message);
    }

    @Override
    public void afterReceiveCompletion(@Nullable Message<?> message, MessageChannel channel, @Nullable Exception ex) {
        log.debug("Outbound afterReceiveCompletion. message={}", message);
    }
}
