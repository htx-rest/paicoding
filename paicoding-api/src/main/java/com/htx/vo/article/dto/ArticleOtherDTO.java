package com.htx.vo.article.dto;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:37
 */
@Data
public class ArticleOtherDTO {
    // 文章的阅读类型
    private Integer readType;
    // 教程的翻页
    private ColumnArticleFlipDTO flip;
}
