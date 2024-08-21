package com.htx.vo.article;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 保存Column文章请求参数
 * @author htx
 * @date 2024/8/20 23:47
 */
@Data
public class ColumnArticleReq implements Serializable {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 专栏ID
     */
    private Long columnId;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 文章排序
     */
    private Integer sort;

    /**
     * 教程标题
     */
    private String shortTitle;

    /**
     * 阅读方式
     */
    private Integer read;
}
