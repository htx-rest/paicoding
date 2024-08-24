package com.htx.article.service.impl;

import com.htx.vo.PageVo;
import com.htx.vo.article.CategoryReq;
import com.htx.vo.article.SearchCategoryReq;
import com.htx.vo.article.dto.CategoryDTO;
import com.htx.util.NumUtil;
import com.htx.article.conveter.CategoryStructMapper;
import com.htx.article.repository.dao.CategoryDao;
import com.htx.article.repository.entity.CategoryDO;
import com.htx.article.repository.params.SearchCategoryParams;
import com.htx.article.service.CategoryService;
import com.htx.article.service.CategorySettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 分类后台接口
 * @author htx
 * @date 2024/8/24 14:39
 */
@Service
public class CategorySettingServiceImpl implements CategorySettingService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void saveCategory(CategoryReq categoryReq) {
        CategoryDO categoryDO = CategoryStructMapper.INSTANCE.toDO(categoryReq);
        if (NumUtil.nullOrZero(categoryReq.getCategoryId())) {
            categoryDao.save(categoryDO);
        } else {
            categoryDO.setId(categoryReq.getCategoryId());
            categoryDao.updateById(categoryDO);
        }
        categoryService.refreshCache();
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        CategoryDO categoryDO = categoryDao.getById(categoryId);
        if (categoryDO != null){
            categoryDao.removeById(categoryDO);
        }
        categoryService.refreshCache();
    }

    @Override
    public void operateCategory(Integer categoryId, Integer pushStatus) {
        CategoryDO categoryDO = categoryDao.getById(categoryId);
        if (categoryDO != null){
            categoryDO.setStatus(pushStatus);
            categoryDao.updateById(categoryDO);
        }
        categoryService.refreshCache();
    }

    @Override
    public PageVo<CategoryDTO> getCategoryList(SearchCategoryReq req) {
        // 转换
        SearchCategoryParams params = CategoryStructMapper.INSTANCE.toSearchParams(req);
        // 查询
        List<CategoryDTO> categoryDTOS = categoryDao.listCategory(params);
        Long totalCount = categoryDao.countCategory(params);
        return PageVo.build(categoryDTOS, params.getPageSize(), params.getPageNum(), totalCount);
    }
}
