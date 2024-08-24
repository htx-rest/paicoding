package com.htx.config.service;

import com.htx.enums.ConfigTypeEnum;
import com.htx.vo.banner.dto.ConfigDTO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * Banner前台接口
 * @author htx
 * @date 2024/8/24 16:29
 */
public interface ConfigService {

    /**
     * 获取 Banner 列表
     *
     * @param configTypeEnum
     * @return
     */
    List<ConfigDTO> getConfigList(ConfigTypeEnum configTypeEnum);

    /**
     * 阅读次数+1
     *
     * @param configId
     * @param extra
     */
    void updateVisit(long configId, String extra);
}
