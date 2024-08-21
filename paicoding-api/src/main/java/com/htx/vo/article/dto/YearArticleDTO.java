package com.htx.vo.article.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 微信搜索「二哈学习之路」
 * 创作历程
 * @author htx
 * @date 2024/8/20 23:46
 */
@Data
@ToString(callSuper = true)
public class YearArticleDTO {

    /**
     * 年份
     */
    private String year;

    /**
     * 文章数量
     */
    private Integer articleCount;
}
