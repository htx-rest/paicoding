package com.htx.front.chat.ws;

import com.htx.context.ReqInfoContext;
import com.htx.mdc.MdcUtil;
import com.htx.util.SpringUtil;
import com.htx.global.GlobalInitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 * v1. 简单版本聊天： 长连接的登录校验拦截器
 * @author htx
 * @date 2024/8/24 23:16
 */
@Slf4j
public class SimpleWsAuthInterceptor extends HttpSessionHandshakeInterceptor implements ChannelInterceptor {

    @Override
    public boolean preReceive(MessageChannel channel) {
        return ChannelInterceptor.super.preReceive(channel);
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String session = ((ServletServerHttpRequest) request).getServletRequest().getParameter("session");
        ReqInfoContext.ReqInfo reqInfo = new ReqInfoContext.ReqInfo();
        SpringUtil.getBean(GlobalInitService.class).initLoginUser(session, reqInfo);
        ReqInfoContext.addReqInfo(reqInfo);
        if (reqInfo.getUserId() == null) {
            // 未登录，拒绝链接
            log.info("用户未登录，拒绝聊天!");
            response.setStatusCode(HttpStatus.FORBIDDEN);
            return false;
        }
        log.info("{} 开始了聊天!", reqInfo);
        MdcUtil.addTraceId();
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        ReqInfoContext.clear();
        MdcUtil.clear();
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
