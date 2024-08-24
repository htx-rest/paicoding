package com.htx.config.service;

import com.htx.vo.PageParam;
import com.htx.vo.PageVo;
import com.htx.vo.banner.ConfigReq;
import com.htx.vo.banner.SearchConfigReq;
import com.htx.vo.banner.dto.ConfigDTO;

/**
 * 微信搜索「二哈学习之路」
 * Banner后台接口
 * @author htx
 * @date 2024/8/24 20:46
 */
public interface ConfigSettingService {

    /**
     * 保存
     *
     * @param configReq
     */
    void saveConfig(ConfigReq configReq);

    /**
     * 删除
     *
     * @param bannerId
     */
    void deleteConfig(Integer bannerId);

    /**
     * 操作（上线/下线）
     *
     * @param bannerId
     */
    void operateConfig(Integer bannerId, Integer pushStatus);

    /**
     * 获取 Banner 列表
     */
    PageVo<ConfigDTO> getConfigList(SearchConfigReq params);

    /**
     * 获取公告列表
     *
     * @param pageParam
     * @return
     */
    PageVo<ConfigDTO> getNoticeList(PageParam pageParam);
}
