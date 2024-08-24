package com.htx.article.service;

import com.htx.enums.HomeSelectEnum;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.PageVo;
import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.article.dto.SimpleArticleDTO;
import com.htx.vo.article.dto.TagDTO;
import com.htx.article.repository.entity.ArticleDO;

import java.util.List;
import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 21:07
 */
public interface ArticleReadService {

    /**
     * 查询基础的文章信息
     *
     * @param articleId
     * @return
     */
    ArticleDO queryBasicArticle(Long articleId);

    /**
     * 提前文章摘要
     *
     * @param content
     * @return
     */
    String generateSummary(String content);

    /**
     * 查询文章标签列表
     *
     * @param articleId
     * @return
     */
    PageVo<TagDTO> queryTagsByArticleId(Long articleId);

    /**
     * 查询文章详情，包括正文内容，分类、标签等信息
     *
     * @param articleId
     * @return
     */
    ArticleDTO queryDetailArticleInfo(Long articleId);

    /**
     * 查询文章所有的关联信息，正文，分类，标签，阅读计数+1，当前登录用户是否点赞、评论过
     *
     * @param articleId   文章id
     * @param currentUser 当前查看的用户ID
     * @return
     */
    ArticleDTO queryFullArticleInfo(Long articleId, Long currentUser);

    /**
     * 查询某个分类下的文章，支持翻页
     *
     * @param categoryId
     * @param page
     * @return
     */
    PageListVo<ArticleDTO> queryArticlesByCategory(Long categoryId, PageParam page);


    /**
     * 获取 Top 文章
     *
     * @param categoryId
     * @return
     */
    List<ArticleDTO> queryTopArticlesByCategory(Long categoryId);


    /**
     * 获取分类文章数
     *
     * @param categoryId
     * @return
     */
    Long queryArticleCountByCategory(Long categoryId);

    /**
     * 根据分类统计文章计数
     *
     * @return
     */
    Map<Long, Long> queryArticleCountsByCategory();

    /**
     * 查询某个标签下的文章，支持翻页
     *
     * @param tagId
     * @param page
     * @return
     */
    PageListVo<ArticleDTO> queryArticlesByTag(Long tagId, PageParam page);

    /**
     * 根据关键词匹配标题，查询用于推荐的文章列表，只返回 articleId + title
     *
     * @param key
     * @return
     */
    List<SimpleArticleDTO> querySimpleArticleBySearchKey(String key);

    /**
     * 根据查询条件查询文章列表，支持翻页
     *
     * @param key
     * @param page
     * @return
     */
    PageListVo<ArticleDTO> queryArticlesBySearchKey(String key, PageParam page);

    /**
     * 查询用户的文章列表
     *
     * @param userId
     * @param pageParam
     * @param select
     * @return
     */
    PageListVo<ArticleDTO> queryArticlesByUserAndType(Long userId, PageParam pageParam, HomeSelectEnum select);

    /**
     * 文章实体补齐统计、作者、分类标签等信息
     *
     * @param records
     * @param pageSize
     * @return
     */
    PageListVo<ArticleDTO> buildArticleListVo(List<ArticleDO> records, long pageSize);

    /**
     * 查询热门文章
     *
     * @param pageParam
     * @return
     */
    PageListVo<SimpleArticleDTO> queryHotArticlesForRecommend(PageParam pageParam);

    /**
     * 查询作者的文章数
     *
     * @param authorId
     * @return
     */
    int queryArticleCount(long authorId);

    /**
     * 返回总的文章计数
     *
     * @return
     */
    Long getArticleCount();
}
