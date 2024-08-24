package com.htx.front.chat.helper;

import com.htx.context.ReqInfoContext;
import com.htx.enums.ai.AISourceEnum;
import com.htx.vo.chat.ChatRecordsVo;
import com.htx.mdc.MdcUtil;
import com.htx.chatai.ChatFacade;
import com.htx.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 23:08
 */
@Slf4j
@Component
public class WsAnswerHelper {
    public static final String AI_SOURCE_PARAM = "AI";

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private ChatFacade chatFacade;

    public void sendMsgToUser(String session, String question) {
        ChatRecordsVo res = chatFacade.autoChat(question, vo -> response(session, vo));
        log.info("AI直接返回：{}", res);
    }

    public void sendMsgToUser(AISourceEnum ai, String session, String question) {
        if (ai == null) {
            // 自动选择AI类型
            sendMsgToUser(session, question);
        } else {
            ChatRecordsVo res = chatFacade.autoChat(ai, question, vo -> response(session, vo));
            log.info("AI直接返回：{}", res);
        }
    }

    public void sendMsgHistoryToUser(String session, AISourceEnum ai) {
        ChatRecordsVo vo = chatFacade.history(ai);
        response(session, vo);
    }

    /**
     * 将返回结果推送给用户
     *
     * @param session
     * @param response
     */
    public void response(String session, ChatRecordsVo response) {
        // convertAndSendToUser 方法可以发送信给给指定用户,
        // 底层会自动将第二个参数目的地址 /chat/rsp 拼接为
        // /user/username/chat/rsp，其中第二个参数 username 即为这里的第一个参数 session
        // username 也是AuthHandshakeHandler中配置的 Principal 用户识别标志
        simpMessagingTemplate.convertAndSendToUser(session, "/chat/rsp", response);
    }

    public void execute(Map<String, Object> attributes, Runnable func) {
        try {
            ReqInfoContext.ReqInfo reqInfo = (ReqInfoContext.ReqInfo) attributes.get(LoginService.SESSION_KEY);
            ReqInfoContext.addReqInfo(reqInfo);
            String traceId = (String) attributes.get(MdcUtil.TRACE_ID_KEY);
            MdcUtil.add(MdcUtil.TRACE_ID_KEY, traceId);


            // 执行具体的业务逻辑
            func.run();

        } finally {
            ReqInfoContext.clear();
            MdcUtil.clear();
        }
    }
}
