package com.htx.vo.notify.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:37
 */
@Data
public class NotifyMsgDTO implements Serializable {
    private static final long serialVersionUID = 3833777672628522348L;

    private Long msgId;

    /**
     * 消息关联的主体，如文章、评论
     */
    private String relatedId;

    /**
     * 关联信息
     */
    private String relatedInfo;

    /**
     * 发起消息的用户id
     */
    private Long operateUserId;

    /**
     * 发起消息的用户名
     */
    private String operateUserName;

    /**
     * 发起消息的用户头像
     */
    private String operateUserPhoto;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息正文
     */
    private String msg;

    /**
     * 1 已读/ 0 未读
     */
    private Integer state;

    /**
     * 消息产生时间
     */
    private Timestamp createTime;
}
