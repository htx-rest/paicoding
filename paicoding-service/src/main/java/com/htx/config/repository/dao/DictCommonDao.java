package com.htx.config.repository.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.vo.article.dto.DictCommonDTO;
import com.htx.config.converter.DictCommonConverter;
import com.htx.config.repository.entity.DictCommonDO;
import com.htx.config.repository.mapper.DictCommonMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 16:26
 */
@Repository
public class DictCommonDao extends ServiceImpl<DictCommonMapper, DictCommonDO> {

    /**
     * 获取所有字典列表
     * @return
     */
    public List<DictCommonDTO> getDictList() {
        List<DictCommonDO> list = lambdaQuery().list();
        return DictCommonConverter.toDTOS(list);
    }
}
