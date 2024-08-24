package com.htx.config.converter;

import com.htx.vo.article.dto.DictCommonDTO;
import com.htx.config.repository.entity.DictCommonDO;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 微信搜索「二哈学习之路」
 * Banner转换
 * @author htx
 * @date 2024/8/24 16:18
 */
public class DictCommonConverter {

    public static List<DictCommonDTO> toDTOS(List<DictCommonDO> records) {
        if (CollectionUtils.isEmpty(records)) {
            return Collections.emptyList();
        }
        return records.stream().map(DictCommonConverter::toDTO).collect(Collectors.toList());
    }

    public static DictCommonDTO toDTO(DictCommonDO dictCommonDO) {
        if (dictCommonDO == null) {
            return null;
        }
        DictCommonDTO dictCommonDTO = new DictCommonDTO();
        dictCommonDTO.setTypeCode(dictCommonDO.getTypeCode());
        dictCommonDTO.setDictCode(dictCommonDO.getDictCode());
        dictCommonDTO.setDictDesc(dictCommonDO.getDictDesc());
        dictCommonDTO.setSortNo(dictCommonDO.getSortNo());
        return dictCommonDTO;
    }
}
