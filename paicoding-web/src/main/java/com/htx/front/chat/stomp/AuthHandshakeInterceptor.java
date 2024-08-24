package com.htx.front.chat.stomp;

import com.htx.context.ReqInfoContext;
import com.htx.mdc.MdcUtil;
import com.htx.mdc.SelfTraceIdGenerator;
import com.htx.util.SessionUtil;
import com.htx.util.SpringUtil;
import com.htx.user.service.LoginService;
import com.htx.front.chat.helper.WsAnswerHelper;
import com.htx.global.GlobalInitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 * 握手拦截器, 用于身份验证识别
 * @author htx
 * @date 2024/8/24 23:12
 */
@Slf4j
public class AuthHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    /**
     * 握手前，进行用户身份校验识别
     *
     * @param request
     * @param response
     * @param wsHandler
     * @param attributes: 即对应的是Message中的 simpSessionAttributes 请求头
     * @return
     * @throws Exception
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("准备开始握手了!");
        String session = SessionUtil.findCookieByName(request, LoginService.SESSION_KEY);
        ReqInfoContext.ReqInfo reqInfo = new ReqInfoContext.ReqInfo();
        SpringUtil.getBean(GlobalInitService.class).initLoginUser(session, reqInfo);

        if (reqInfo.getUser() == null) {
            log.info("websocket 握手失败，请登录之后再试");
            return false;
        }

        // 将用户信息写入到属性中
        attributes.put(MdcUtil.TRACE_ID_KEY, SelfTraceIdGenerator.generate());
        attributes.put(LoginService.SESSION_KEY, reqInfo);
        attributes.put(WsAnswerHelper.AI_SOURCE_PARAM, initAiSource(request.getURI().getPath()));
        return true;
    }

    private String initAiSource(String path) {
        int index = path.lastIndexOf("/");
        return path.substring(index + 1);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        log.info("握手成功了!!!");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}
