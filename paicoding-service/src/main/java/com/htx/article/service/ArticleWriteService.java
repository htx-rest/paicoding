package com.htx.article.service;

import com.htx.vo.article.ArticlePostReq;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 21:10
 */
public interface ArticleWriteService {

    /**
     * 保存or更新文章
     *
     * @param req    上传的文章体
     * @param author 作者
     * @return 返回文章主键
     */
    Long saveArticle(ArticlePostReq req, Long author);

    /**
     * 删除文章
     *
     * @param articleId   文章id
     * @param loginUserId 执行操作的用户
     */
    void deleteArticle(Long articleId, Long loginUserId);
}
