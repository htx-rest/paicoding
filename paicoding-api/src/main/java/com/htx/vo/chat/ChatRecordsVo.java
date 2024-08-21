package com.htx.vo.chat;

import com.htx.enums.ai.AISourceEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信搜索「二哈学习之路」
 * 聊天记录
 * @author htx
 * @date 2024/8/21 20:14
 */
@Data
@Accessors(chain = true)
public class ChatRecordsVo implements Serializable, Cloneable {
    private static final long serialVersionUID = -2666259615985932920L;
    /**
     * AI来源
     */
    private AISourceEnum source;

    /**
     * 当前用户最多可问答的次数
     */
    private int maxCnt;

    /**
     * 使用的次数
     */
    private int usedCnt;

    /**
     * 聊天记录，最新的在前面；最多返回50条
     */
    private List<ChatItemVo> records;

    @Override
    public ChatRecordsVo clone() {
        ChatRecordsVo vo = new ChatRecordsVo();
        vo.source = source;
        vo.maxCnt = maxCnt;
        vo.usedCnt = usedCnt;
        if (records != null) {
            vo.setRecords(records.stream().map(ChatItemVo::clone).collect(Collectors.toList()));
        }
        return vo;
    }

    /**
     * 判断是否拥有提问次数
     *
     * @return true 表示拥有提问次数
     */
    public boolean hasQaCnt() {
        return maxCnt > usedCnt;
    }
}
