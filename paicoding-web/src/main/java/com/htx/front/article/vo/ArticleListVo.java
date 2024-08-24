package com.htx.front.article.vo;

import com.htx.vo.PageListVo;
import com.htx.vo.article.dto.ArticleDTO;
import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:39
 */
@Data
public class ArticleListVo {
    /**
     * 归档类型
     */
    private String archives;
    /**
     * 归档id
     */
    private Long archiveId;

    private PageListVo<ArticleDTO> articles;
}
