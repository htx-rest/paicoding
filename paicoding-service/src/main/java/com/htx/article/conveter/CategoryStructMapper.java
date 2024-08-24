package com.htx.article.conveter;

import com.htx.vo.article.CategoryReq;
import com.htx.vo.article.SearchCategoryReq;
import com.htx.vo.article.dto.CategoryDTO;
import com.htx.article.repository.entity.CategoryDO;
import com.htx.article.repository.params.SearchCategoryParams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:21
 */
@Mapper
public interface CategoryStructMapper {
    // instance
    CategoryStructMapper INSTANCE = Mappers.getMapper( CategoryStructMapper.class );

    // req to params
    @Mapping(source = "pageNumber", target = "pageNum")
    SearchCategoryParams toSearchParams(SearchCategoryReq req);

    // do to dto
    @Mapping(source = "id", target = "categoryId")
    @Mapping(source = "categoryName", target = "category")
    CategoryDTO toDTO(CategoryDO categoryDO);

    List<CategoryDTO> toDTOs(List<CategoryDO> list);

    // req to do
    @Mapping(source = "category", target = "categoryName")
    CategoryDO toDO(CategoryReq categoryReq);
}
