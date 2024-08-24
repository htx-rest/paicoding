package com.htx.article.service;

import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.article.dto.ArticleDTO;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 21:08
 */
public interface ArticleRecommendService {
    /**
     * 文章关联推荐
     *
     * @param article
     * @param pageParam
     * @return
     */
    PageListVo<ArticleDTO> relatedRecommend(Long article, PageParam pageParam);
}
