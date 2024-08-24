package com.htx.article.conveter;

import com.htx.vo.article.SearchArticleReq;
import com.htx.article.repository.params.SearchArticleParams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:20
 */
@Mapper
public interface ArticleStructMapper {
    ArticleStructMapper INSTANCE = Mappers.getMapper( ArticleStructMapper.class );

    @Mapping(source = "pageNumber", target = "pageNum")
    SearchArticleParams toSearchParams(SearchArticleReq req);
}
