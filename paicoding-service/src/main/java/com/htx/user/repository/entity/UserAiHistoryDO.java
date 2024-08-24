package com.htx.user.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import com.htx.enums.ai.AISourceEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 * AI 历史消息表
 * @author htx
 * @date 2024/8/24 15:05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("user_ai_history")
public class UserAiHistoryDO extends BaseDO {

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 问题
     */
    private String question;

    /**
     * 答案
     */
    private String answer;

    /**
     * AI 类型
     *
     * @see AISourceEnum#getCode()
     */
    private Integer aiType;

}
