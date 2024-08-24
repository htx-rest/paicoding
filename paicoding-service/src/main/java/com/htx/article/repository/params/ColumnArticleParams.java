package com.htx.article.repository.params;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:37
 */
@Data
public class ColumnArticleParams {
    // 教程 ID
    private Long columnId;
    // 文章 ID
    private Long articleId;
    // section
    private Integer section;
}
