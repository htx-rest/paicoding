package com.htx.vo.article.dto;

import com.htx.enums.column.ColumnTypeEnum;
import com.htx.vo.comment.dto.TopCommentDTO;
import lombok.Data;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:40
 */
@Data
public class ColumnArticlesDTO {
    /**
     * 专栏详情
     */
    private Long column;

    /**
     * 当前查看的文章
     */
    private Integer section;

    /**
     * 文章详情
     */
    private ArticleDTO article;

    /**
     * 0 免费阅读
     * 1 要求登录阅读
     * 2 限时免费，若当前时间超过限时免费期，则调整为登录阅读
     *
     * @see ColumnTypeEnum#getType()
     */
    private Integer readType;

    /**
     * 文章评论
     */
    private List<TopCommentDTO> comments;

    /**
     * 热门评论
     */
    private TopCommentDTO hotComment;

    /**
     * 文章目录列表
     */
    private List<SimpleArticleDTO> articleList;

    // 翻页
    private ArticleOtherDTO other;
}
