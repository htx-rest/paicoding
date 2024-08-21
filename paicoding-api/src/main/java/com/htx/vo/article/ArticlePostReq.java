package com.htx.vo.article;

import com.htx.enums.ArticleTypeEnum;
import com.htx.enums.PushStatusEnum;
import com.htx.enums.SourceTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * 微信搜索「二哈学习之路」
 * 发布文章请求参数
 * @author htx
 * @date 2024/8/20 23:32
 */
@Data
public class ArticlePostReq implements Serializable {
    /**
     * 文章ID， 当存在时，表示更新文章
     */
    private Long articleId;
    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章短标题
     */
    private String shortTitle;

    /**
     * 分类
     */
    private Long categoryId;

    /**
     * 标签
     */
    private Set<Long> tagIds;

    /**
     * 简介
     */
    private String summary;

    /**
     * 正文内容
     */
    private String content;

    /**
     * 封面
     */
    private String cover;

    /**
     * 文本类型
     *
     * @see ArticleTypeEnum
     */
    private String articleType;


    /**
     * 来源：1-转载，2-原创，3-翻译
     *
     * @see SourceTypeEnum
     */
    private Integer source;

    /**
     * 状态：0-未发布，1-已发布
     *
     * @see com.htx.enums.PushStatusEnum
     */
    private Integer status;

    /**
     * 原文地址
     */
    private String sourceUrl;

    /**
     * POST 发表, SAVE 暂存 DELETE 删除
     */
    private String actionType;

    /**
     * 专栏序号
     */
    private Long columnId;

    public PushStatusEnum pushStatus() {
        if ("post".equalsIgnoreCase(actionType)) {
            return PushStatusEnum.ONLINE;
        } else {
            return PushStatusEnum.OFFLINE;
        }
    }

    public boolean deleted() {
        return "delete".equalsIgnoreCase(actionType);
    }
}
