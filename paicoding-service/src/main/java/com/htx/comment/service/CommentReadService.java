package com.htx.comment.service;

import com.htx.vo.PageParam;
import com.htx.vo.comment.dto.TopCommentDTO;
import com.htx.comment.repository.entity.CommentDO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 评论Service接口
 * @author htx
 * @date 2024/8/24 15:50
 */
public interface CommentReadService {

    /**
     * 根据评论id查询评论信息
     *
     * @param commentId
     * @return
     */
    CommentDO queryComment(Long commentId);

    /**
     * 查询文章评论列表
     *
     * @param articleId
     * @param page
     * @return
     */
    List<TopCommentDTO> getArticleComments(Long articleId, PageParam page);

    /**
     * 查询热门评论
     *
     * @param articleId
     * @return
     */
    TopCommentDTO queryHotComment(Long articleId);

    /**
     * 文章的有效评论数
     *
     * @param articleId
     * @return
     */
    int queryCommentCount(Long articleId);
}
