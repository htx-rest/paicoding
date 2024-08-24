package com.htx.article.conveter;

import com.htx.vo.article.ColumnArticleReq;
import com.htx.vo.article.SearchColumnArticleReq;
import com.htx.article.repository.entity.ColumnArticleDO;
import com.htx.article.repository.params.ColumnArticleParams;
import com.htx.article.repository.params.SearchColumnArticleParams;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:22
 */
@Mapper
public interface ColumnArticleStructMapper {
    ColumnArticleStructMapper INSTANCE = Mappers.getMapper( ColumnArticleStructMapper.class );

    SearchColumnArticleParams toSearchParams(SearchColumnArticleReq req);

    ColumnArticleParams toParams(ColumnArticleReq req);

    ColumnArticleDO reqToDO(ColumnArticleReq req);
}
