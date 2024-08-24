package com.htx.article.service;

import com.htx.vo.article.dto.CategoryDTO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 标签Service
 * @author htx
 * @date 2024/8/22 21:10
 */
public interface CategoryService {
    /**
     * 查询类目名
     *
     * @param categoryId
     * @return
     */
    String queryCategoryName(Long categoryId);


    /**
     * 查询所有的分离
     *
     * @return
     */
    List<CategoryDTO> loadAllCategories();

    /**
     * 查询类目id
     *
     * @param category
     * @return
     */
    Long queryCategoryId(String category);


    /**
     * 刷新缓存
     */
    public void refreshCache();
}
