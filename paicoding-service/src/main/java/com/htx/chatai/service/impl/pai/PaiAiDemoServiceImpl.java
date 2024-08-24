package com.htx.chatai.service.impl.pai;

import com.htx.enums.ChatAnswerTypeEnum;
import com.htx.enums.ai.AISourceEnum;
import com.htx.enums.ai.AiChatStatEnum;
import com.htx.vo.chat.ChatItemVo;
import com.htx.vo.chat.ChatRecordsVo;
import com.htx.async.AsyncUtil;
import com.htx.chatai.service.AbsChatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

/**
 * 微信搜索「二哈学习之路」
 * 技术派价值一个亿的AI
 * @author htx
 * @date 2024/8/24 21:27
 */
@Service
public class PaiAiDemoServiceImpl extends AbsChatService {

    @Override
    public AISourceEnum source() {
        return AISourceEnum.PAI_AI;
    }

    @Override
    public AiChatStatEnum doAnswer(Long user, ChatItemVo chat) {
        chat.initAnswer(qa(chat.getQuestion()));
        return AiChatStatEnum.END;
    }

    @Override
    public AiChatStatEnum doAsyncAnswer(Long user, ChatRecordsVo response, BiConsumer<AiChatStatEnum, ChatRecordsVo> consumer) {
        AsyncUtil.execute(() -> {
            AsyncUtil.sleep(1500);
            ChatItemVo item = response.getRecords().get(0);
            item.appendAnswer(qa(item.getQuestion()));
            consumer.accept(AiChatStatEnum.FIRST, response);

            AsyncUtil.sleep(1200);
            item.appendAnswer("\n" + qa(item.getQuestion()));
            item.setAnswerType(ChatAnswerTypeEnum.STREAM_END);
            consumer.accept(AiChatStatEnum.END, response);
        });
        return AiChatStatEnum.END;
    }

    private String qa(String q) {
        String ans = q.replace("吗", "");
        ans = StringUtils.replace(ans, "？", "!");
        ans = StringUtils.replace(ans, "?", "!");
        return ans;
    }

    @Override
    protected int getMaxQaCnt(Long user) {
        return 65535;
    }
}
