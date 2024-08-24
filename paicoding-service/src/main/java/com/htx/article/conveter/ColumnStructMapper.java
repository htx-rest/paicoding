package com.htx.article.conveter;

import com.htx.vo.article.ColumnReq;
import com.htx.vo.article.SearchColumnReq;
import com.htx.vo.article.dto.ColumnDTO;
import com.htx.vo.article.dto.SimpleColumnDTO;
import com.htx.article.repository.entity.ColumnInfoDO;
import com.htx.article.repository.params.SearchColumnParams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:24
 */
@Mapper(componentModel = "spring")
public interface ColumnStructMapper {
    ColumnStructMapper INSTANCE = Mappers.getMapper( ColumnStructMapper.class);

    /**
     * SearchColumnReq to SearchColumnParams
     * @param req
     * @return
     */
    SearchColumnParams reqToSearchParams(SearchColumnReq req);

    /**
     * ColumnInfoDO to ColumnDTO
     * @param columnInfoDO
     * @return
     */
    // sources 是参数，target 是目标
    @Mapping(source = "id", target = "columnId")
    @Mapping(source = "columnName", target = "column")
    @Mapping(source = "userId", target = "author")
    // Date 转 Long
    @Mapping(target = "publishTime", expression = "java(columnInfoDO.getPublishTime().getTime())")
    @Mapping(target = "freeStartTime", expression = "java(columnInfoDO.getFreeStartTime().getTime())")
    @Mapping(target = "freeEndTime", expression = "java(columnInfoDO.getFreeEndTime().getTime())")
    ColumnDTO infotoDto(ColumnInfoDO columnInfoDO);

    List<ColumnDTO> infoToDtos(List<ColumnInfoDO> columnInfoDOs);


    /**
     * ColumnInfoDO to SimpleColumnDTO
     * @param columnInfoDO
     * @return
     */
    // 专栏 ID 、专栏名、封面
    @Mapping(source = "id", target = "columnId")
    @Mapping(source = "columnName", target = "column")
    SimpleColumnDTO infoToSimpleDto(ColumnInfoDO columnInfoDO);

    List<SimpleColumnDTO> infoToSimpleDtos(List<ColumnInfoDO> columnInfoDOs);

    @Mapping(source = "column", target = "columnName")
    @Mapping(source = "author", target = "userId")
    // Long 转 Date
    @Mapping(target = "freeStartTime", expression = "java(new java.util.Date(req.getFreeStartTime()))")
    @Mapping(target = "freeEndTime", expression = "java(new java.util.Date(req.getFreeEndTime()))")
    ColumnInfoDO toDo(ColumnReq req);
}
