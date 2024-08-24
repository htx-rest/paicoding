package com.htx.config.service.impl;

import com.htx.enums.ConfigTypeEnum;
import com.htx.vo.banner.dto.ConfigDTO;
import com.htx.config.repository.dao.ConfigDao;
import com.htx.config.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * Banner前台接口
 * @author htx
 * @date 2024/8/24 20:49
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigDao configDao;

    @Override
    public List<ConfigDTO> getConfigList(ConfigTypeEnum configTypeEnum) {
        return configDao.listConfigByType(configTypeEnum.getCode());
    }

    /**
     * 配置发生变更之后，失效本地缓存，这里主要是配合 SidebarServiceImpl 中的缓存使用
     *
     * @param configId
     * @param extra
     */
    @Override
    public void updateVisit(long configId, String extra) {
        configDao.updatePdfConfigVisitNum(configId, extra);
    }
}
