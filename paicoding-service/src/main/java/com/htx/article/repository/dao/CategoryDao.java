package com.htx.article.repository.dao;

import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.enums.PushStatusEnum;
import com.htx.enums.YesOrNoEnum;
import com.htx.vo.PageParam;
import com.htx.vo.article.dto.CategoryDTO;
import com.htx.article.conveter.CategoryStructMapper;
import com.htx.article.repository.entity.CategoryDO;
import com.htx.article.repository.mapper.CategoryMapper;
import com.htx.article.repository.params.SearchCategoryParams;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 类目Service
 * @author htx
 * @date 2024/8/22 21:01
 */
@Repository
public class CategoryDao extends ServiceImpl<CategoryMapper, CategoryDO> {
    /**
     * @return
     */
    public List<CategoryDO> listAllCategoriesFromDb() {
        return lambdaQuery()
                .eq(CategoryDO::getDeleted, YesOrNoEnum.NO.getCode())
                .eq(CategoryDO::getStatus, PushStatusEnum.ONLINE.getCode())
                .list();
    }

    // 抽一个私有方法，构造查询条件
    private LambdaQueryChainWrapper<CategoryDO> createCategoryQuery(SearchCategoryParams params) {
        return lambdaQuery()
                .eq(CategoryDO::getDeleted, YesOrNoEnum.NO.getCode())
                .like(StringUtils.isNotBlank(params.getCategory()), CategoryDO::getCategoryName, params.getCategory());
    }

    /**
     * 获取所有 Categorys 列表（分页）
     *
     * @return
     */
    public List<CategoryDTO> listCategory(SearchCategoryParams params) {
        List<CategoryDO> list = createCategoryQuery(params)
                .orderByDesc(CategoryDO::getUpdateTime)
                .orderByAsc(CategoryDO::getRank)
                .last(PageParam.getLimitSql(
                        PageParam.newPageInstance(params.getPageNum(), params.getPageSize())
                ))
                .list();
        return CategoryStructMapper.INSTANCE.toDTOs(list);
    }

    /**
     * 获取所有 Categorys 总数（分页）
     *
     * @return
     */
    public Long countCategory(SearchCategoryParams params) {
        return createCategoryQuery(params)
                .count();
    }
}
