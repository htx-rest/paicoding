package com.htx.article.service;

import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.article.dto.ColumnDTO;
import com.htx.vo.article.dto.SimpleArticleDTO;
import com.htx.article.repository.entity.ColumnArticleDO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 21:12
 */
public interface ColumnService {
    /**
     * 根据文章id，构建对应的专栏详情地址
     *
     * @param articleId 文章主键
     * @return 专栏详情页
     */
    ColumnArticleDO getColumnArticleRelation(Long articleId);

    /**
     * 专栏列表
     *
     * @param pageParam
     * @return
     */
    PageListVo<ColumnDTO> listColumn(PageParam pageParam);

    /**
     * 获取专栏中的第N篇文章
     *
     * @param columnId
     * @param order
     * @return
     */
    ColumnArticleDO queryColumnArticle(long columnId, Integer order);

    /**
     * 只查询基本的专栏信息，不需要统计、作者等信息
     *
     * @param columnId
     * @return
     */
    ColumnDTO queryBasicColumnInfo(Long columnId);

    /**
     * 专栏详情
     *
     * @param columnId
     * @return
     */
    ColumnDTO queryColumnInfo(Long columnId);

    /**
     * 专栏 + 文章列表详情
     *
     * @param columnId
     * @return
     */
    List<SimpleArticleDTO> queryColumnArticles(long columnId);

    /**
     * 返回教程数量
     *
     * @return
     */
    Long getTutorialCount();
}
