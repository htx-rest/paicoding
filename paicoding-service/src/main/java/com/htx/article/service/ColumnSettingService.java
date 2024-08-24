package com.htx.article.service;

import com.htx.vo.PageVo;
import com.htx.vo.article.*;
import com.htx.vo.article.dto.ColumnArticleDTO;
import com.htx.vo.article.dto.ColumnDTO;
import com.htx.vo.article.dto.SimpleColumnDTO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 专栏后台接口
 * @author htx
 * @date 2024/8/22 21:15
 */
public interface ColumnSettingService {

    /**
     * 将文章保存到对应的专栏中
     *
     * @param articleId
     * @param columnId
     */
    void saveColumnArticle(Long articleId, Long columnId);

    /**
     * 保存专栏
     *
     * @param columnReq
     */
    void saveColumn(ColumnReq columnReq);

    /**
     * 保存专栏文章
     *
     * @param req
     */
    void saveColumnArticle(ColumnArticleReq req);

    /**
     * 删除专栏
     *
     * @param columnId
     */
    void deleteColumn(Long columnId);

    /**
     * 删除专栏文章
     *
     * @param id
     */
    void deleteColumnArticle(Long id);

    /**
     * 通过关键词，从标题中找出相似的进行推荐，只返回主键 + 标题
     *
     * @param key
     * @return
     */
    List<SimpleColumnDTO> listSimpleColumnBySearchKey(String key);

    PageVo<ColumnDTO> getColumnList(SearchColumnReq req);

    PageVo<ColumnArticleDTO> getColumnArticleList(SearchColumnArticleReq req);

    void sortColumnArticleApi(SortColumnArticleReq req);

    void sortColumnArticleByIDApi(SortColumnArticleByIDReq req);
}
