package com.htx.config.converter;

import com.htx.vo.banner.ConfigReq;
import com.htx.vo.banner.SearchConfigReq;
import com.htx.vo.banner.dto.ConfigDTO;
import com.htx.vo.config.GlobalConfigReq;
import com.htx.vo.config.SearchGlobalConfigReq;
import com.htx.vo.config.dto.GlobalConfigDTO;
import com.htx.config.repository.entity.ConfigDO;
import com.htx.config.repository.entity.GlobalConfigDO;
import com.htx.config.repository.params.SearchConfigParams;
import com.htx.config.repository.params.SearchGlobalConfigParams;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 16:18
 */
@Mapper
public interface ConfigStructMapper {
    // instance
    ConfigStructMapper INSTANCE = Mappers.getMapper( ConfigStructMapper.class );

    // req to params
    @Mapping(source = "pageNumber", target = "pageNum")
    SearchConfigParams toSearchParams(SearchConfigReq req);

    // req to params
    @Mapping(source = "pageNumber", target = "pageNum")
    // key to keywords
    @Mapping(source = "keywords", target = "key")
    SearchGlobalConfigParams toSearchGlobalParams(SearchGlobalConfigReq req);

    // do to dto
    ConfigDTO toDTO(ConfigDO configDO);

    List<ConfigDTO> toDTOS(List<ConfigDO> configDOS);

    ConfigDO toDO(ConfigReq configReq);

    // do to dto
    // key to keywords
    @Mapping(source = "key", target = "keywords")
    GlobalConfigDTO toGlobalDTO(GlobalConfigDO configDO);

    List<GlobalConfigDTO> toGlobalDTOS(List<GlobalConfigDO> configDOS);

    @Mapping(source = "keywords", target = "key")
    GlobalConfigDO toGlobalDO(GlobalConfigReq req);
}
