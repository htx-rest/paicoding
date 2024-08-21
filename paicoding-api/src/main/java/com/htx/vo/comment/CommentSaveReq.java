package com.htx.vo.comment;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 评论列表入参
 * @author htx
 * @date 2024/8/21 20:31
 */
@Data
public class CommentSaveReq {

    /**
     * 评论ID
     */
    private Long commentId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 父评论ID
     */
    private Long parentCommentId;

    /**
     * 顶级评论ID
     */
    private Long topCommentId;
}
