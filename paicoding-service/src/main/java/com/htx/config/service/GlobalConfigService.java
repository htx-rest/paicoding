package com.htx.config.service;

import com.htx.vo.PageVo;
import com.htx.vo.config.GlobalConfigReq;
import com.htx.vo.config.SearchGlobalConfigReq;
import com.htx.vo.config.dto.GlobalConfigDTO;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 20:48
 */
public interface GlobalConfigService {
    PageVo<GlobalConfigDTO> getList(SearchGlobalConfigReq req);

    void save(GlobalConfigReq req);

    void delete(Long id);

    /**
     * 添加敏感词白名单
     *
     * @param word
     */
    void addSensitiveWhiteWord(String word);
}
