package com.htx.user.converter;

import com.htx.vo.user.SearchZsxqUserReq;
import com.htx.user.repository.params.SearchZsxqWhiteParams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 15:01
 */
@Mapper
public interface UserStructMapper {
    UserStructMapper INSTANCE = Mappers.getMapper( UserStructMapper.class );
    // req to params
    @Mapping(source = "pageNumber", target = "pageNum")
    // state to status
    @Mapping(source = "state", target = "status")
    SearchZsxqWhiteParams toSearchParams(SearchZsxqUserReq req);
}
