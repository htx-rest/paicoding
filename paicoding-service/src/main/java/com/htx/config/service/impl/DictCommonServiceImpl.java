package com.htx.config.service.impl;

import com.htx.vo.article.dto.CategoryDTO;
import com.htx.vo.article.dto.DictCommonDTO;
import com.htx.article.service.CategoryService;
import com.htx.config.repository.dao.DictCommonDao;
import com.htx.config.service.DictCommonService;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 * 字典Service
 * @author htx
 * @date 2024/8/24 20:51
 */
@Service
public class DictCommonServiceImpl implements DictCommonService {

    @Resource
    private DictCommonDao dictCommonDao;

    @Autowired
    private CategoryService categoryService;

    @Override
    public Map<String, Object> getDict() {
        Map<String, Object> result = Maps.newLinkedHashMap();

        List<DictCommonDTO> dictCommonList = dictCommonDao.getDictList();

        Map<String, Map<String, String>> dictCommonMap = Maps.newLinkedHashMap();
        for (DictCommonDTO dictCommon : dictCommonList) {
            Map<String, String> codeMap = dictCommonMap.get(dictCommon.getTypeCode());
            if (codeMap == null || codeMap.isEmpty()) {
                codeMap = Maps.newLinkedHashMap();
                dictCommonMap.put(dictCommon.getTypeCode(), codeMap);
            }
            codeMap.put(dictCommon.getDictCode(), dictCommon.getDictDesc());
        }

        // 获取分类的字典信息
        List<CategoryDTO> categoryDTOS = categoryService.loadAllCategories();
        Map<String, String> codeMap = new HashMap<>();
        categoryDTOS.forEach(categoryDTO -> codeMap.put(categoryDTO.getCategoryId().toString(), categoryDTO.getCategory()));
        dictCommonMap.put("CategoryType", codeMap);

        result.putAll(dictCommonMap);
        return result;
    }

}
