package com.htx.article.repository.params;

import com.htx.vo.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 * 专栏查询
 * @author htx
 * @date 2024/8/22 20:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchColumnArticleParams extends PageParam {

    /**
     * 专栏名称
     */
    private String column;

    /**
     * 专栏id
     */
    private Long columnId;

    /**
     * 文章标题
     */
    private String articleTitle;
}
