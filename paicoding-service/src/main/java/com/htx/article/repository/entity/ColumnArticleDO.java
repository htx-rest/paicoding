package com.htx.article.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import com.htx.enums.column.ColumnArticleReadEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 * 专栏文章
 * @author htx
 * @date 2024/8/22 20:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("column_article")
public class ColumnArticleDO extends BaseDO {
    private static final long serialVersionUID = -2372103913090667453L;

    private Long columnId;

    private Long articleId;

    /**
     * 顺序，越小越靠前
     */
    private Integer section;

    /**
     * 专栏类型：免费、登录阅读、收费阅读等
     *
     * @see ColumnArticleReadEnum#getRead()
     */
    private Integer readType;
}
