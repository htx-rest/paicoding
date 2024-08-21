package com.htx.vo.user.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 微信搜索「二哈学习之路」
 * 用户主页信息
 * @author htx
 * @date 2024/8/21 20:25
 */
@Data
@ToString(callSuper = true)
public class UserFootStatisticDTO {

    /**
     * 文章点赞数
     */
    private Long praiseCount;

    /**
     * 文章被阅读数
     */
    private Long readCount;

    /**
     * 文章被收藏数
     */
    private Long collectionCount;

    /**
     * 文章被评论数
     */
    private Long commentCount;

    public UserFootStatisticDTO() {
        praiseCount = 0L;
        readCount = 0L;
        collectionCount = 0L;
        commentCount = 0L;
    }
}
