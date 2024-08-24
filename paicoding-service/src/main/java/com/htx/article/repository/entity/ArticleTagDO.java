package com.htx.article.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 * 文章标签映射表
 * @author htx
 * @date 2024/8/22 20:30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("article_tag")
public class ArticleTagDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 文章ID
     */
    private Long articleId;

    /**
     * 标签id
     */
    private Long tagId;

    private Integer deleted;
}
