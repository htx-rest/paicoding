package com.htx.front.chat.ws;

import com.htx.front.chat.rest.SimpleChatgptHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 微信搜索「二哈学习之路」
 * v1.0 基础版本的websocket长连接相关配置
 * @author htx
 * @date 2024/8/24 23:17
 */
public class SimpleWsConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatWebSocketHandler(), "/chatgpt")
                .setAllowedOrigins("*")
                .addInterceptors(new SimpleWsAuthInterceptor());
    }

    @Bean
    public WebSocketHandler chatWebSocketHandler() {
        return new SimpleChatgptHandler();
    }
}
