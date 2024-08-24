package com.htx.comment.service;

import com.htx.vo.comment.CommentSaveReq;

/**
 * 微信搜索「二哈学习之路」
 * 评论Service接口
 * @author htx
 * @date 2024/8/24 15:51
 */
public interface CommentWriteService {

    /**
     * 更新/保存评论
     *
     * @param commentSaveReq
     * @return
     */
    Long saveComment(CommentSaveReq commentSaveReq);

    /**
     * 删除评论
     *
     * @param commentId
     * @throws Exception
     */
    void deleteComment(Long commentId, Long userId);

}
