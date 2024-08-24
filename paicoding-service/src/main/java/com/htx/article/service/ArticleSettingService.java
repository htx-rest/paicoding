package com.htx.article.service;

import com.htx.enums.OperateArticleEnum;
import com.htx.vo.PageVo;
import com.htx.vo.article.ArticlePostReq;
import com.htx.vo.article.SearchArticleReq;
import com.htx.vo.article.dto.ArticleAdminDTO;

/**
 * 微信搜索「二哈学习之路」
 * 文章后台接口
 * @author htx
 * @date 2024/8/22 21:09
 */
public interface ArticleSettingService {

    /**
     * 更新文章
     *
     * @param req
     */
    void updateArticle(ArticlePostReq req);

    /**
     * 获取文章列表
     *
     * @param req
     * @return
     */
    PageVo<ArticleAdminDTO> getArticleList(SearchArticleReq req);

    /**
     * 删除文章
     *
     * @param articleId
     */
    void deleteArticle(Long articleId);

    /**
     * 操作文章
     *
     * @param articleId
     * @param operate
     */
    void operateArticle(Long articleId, OperateArticleEnum operate);
}
