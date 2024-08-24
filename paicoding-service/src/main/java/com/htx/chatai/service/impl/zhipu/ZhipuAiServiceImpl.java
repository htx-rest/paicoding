package com.htx.chatai.service.impl.zhipu;

import com.htx.enums.ai.AISourceEnum;
import com.htx.enums.ai.AiChatStatEnum;
import com.htx.vo.chat.ChatItemVo;
import com.htx.vo.chat.ChatRecordsVo;
import com.htx.chatai.service.AbsChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 21:30
 */
@Slf4j
@Service
public class ZhipuAiServiceImpl extends AbsChatService {

    @Autowired
    private ZhipuIntegration zhipuIntegration;

    @Override
    public AiChatStatEnum doAnswer(Long user, ChatItemVo chat) {
        if (zhipuIntegration.directReturn(user, chat)) {
            return AiChatStatEnum.END;
        }
        return AiChatStatEnum.ERROR;
    }

    @Override
    public AiChatStatEnum doAsyncAnswer(Long user, ChatRecordsVo chatRes, BiConsumer<AiChatStatEnum, ChatRecordsVo> consumer) {
        zhipuIntegration.streamReturn(user, chatRes, consumer);
        return AiChatStatEnum.IGNORE;
    }

    @Override
    public AISourceEnum source() {
        return AISourceEnum.ZHI_PU_AI;
    }

    @Override
    public boolean asyncFirst() {
        // true 表示优先使用异步返回； false 表示同步等待结果
        return true;
    }

}
