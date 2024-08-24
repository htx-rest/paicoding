package com.htx.article.service;

import com.htx.vo.PageVo;
import com.htx.vo.article.CategoryReq;
import com.htx.vo.article.SearchCategoryReq;
import com.htx.vo.article.dto.CategoryDTO;

/**
 * 微信搜索「二哈学习之路」
 * 分类后台接口
 * @author htx
 * @date 2024/8/22 21:11
 */
public interface CategorySettingService {

    void saveCategory(CategoryReq categoryReq);

    void deleteCategory(Integer categoryId);

    void operateCategory(Integer categoryId, Integer pushStatus);

    /**
     * 获取category列表
     *
     * @param params
     * @return
     */
    PageVo<CategoryDTO> getCategoryList(SearchCategoryReq params);
}
