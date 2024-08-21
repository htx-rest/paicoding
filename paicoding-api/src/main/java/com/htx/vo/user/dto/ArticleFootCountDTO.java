package com.htx.vo.user.dto;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 文章足迹计数
 * @author htx
 * @date 2024/8/21 20:20
 */
@Data
public class ArticleFootCountDTO {

    /**
     * 文章点赞数
     */
    private Integer  praiseCount;

    /**
     * 文章被阅读数
     */
    private Integer  readCount;

    /**
     * 文章被收藏数
     */
    private Integer  collectionCount;

    /**
     * 评论数
     */
    private Integer commentCount;

    public ArticleFootCountDTO() {
        praiseCount = 0;
        readCount = 0;
        collectionCount = 0;
        commentCount = 0;
    }
}
