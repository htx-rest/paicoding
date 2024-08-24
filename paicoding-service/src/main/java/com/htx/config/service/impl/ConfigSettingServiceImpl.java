package com.htx.config.service.impl;

import com.htx.enums.YesOrNoEnum;
import com.htx.vo.PageParam;
import com.htx.vo.PageVo;
import com.htx.vo.banner.ConfigReq;
import com.htx.vo.banner.SearchConfigReq;
import com.htx.vo.banner.dto.ConfigDTO;
import com.htx.util.NumUtil;
import com.htx.config.converter.ConfigStructMapper;
import com.htx.config.repository.dao.ConfigDao;
import com.htx.config.repository.entity.ConfigDO;
import com.htx.config.repository.params.SearchConfigParams;
import com.htx.config.service.ConfigSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * Banner后台接口
 * @author htx
 * @date 2024/8/24 20:50
 */
@Service
public class ConfigSettingServiceImpl implements ConfigSettingService {

    @Autowired
    private ConfigDao configDao;

    @Override
    public void saveConfig(ConfigReq configReq) {
        ConfigDO configDO = ConfigStructMapper.INSTANCE.toDO(configReq);
        if (NumUtil.nullOrZero(configReq.getConfigId())) {
            configDao.save(configDO);
        } else {
            configDO.setId(configReq.getConfigId());
            configDao.updateById(configDO);
        }
    }

    @Override
    public void deleteConfig(Integer configId) {
        ConfigDO configDO = configDao.getById(configId);
        if (configDO != null){
            configDO.setDeleted(YesOrNoEnum.YES.getCode());
            configDao.updateById(configDO);
        }
    }

    @Override
    public void operateConfig(Integer configId, Integer pushStatus) {
        ConfigDO configDO = configDao.getById(configId);
        if (configDO != null){
            configDO.setStatus(pushStatus);
            configDao.updateById(configDO);
        }
    }

    @Override
    public PageVo<ConfigDTO> getConfigList(SearchConfigReq req) {
        // 转换
        SearchConfigParams params = ConfigStructMapper.INSTANCE.toSearchParams(req);
        // 查询
        List<ConfigDTO> configDTOS = configDao.listBanner(params);
        Long totalCount = configDao.countConfig(params);
        return PageVo.build(configDTOS, params.getPageSize(), params.getPageNum(), totalCount);
    }

    @Override
    public PageVo<ConfigDTO> getNoticeList(PageParam pageParam) {
        List<ConfigDTO> configDTOS = configDao.listNotice(pageParam);
        Integer totalCount = configDao.countNotice();
        return PageVo.build(configDTOS, pageParam.getPageSize(), pageParam.getPageNum(), totalCount);
    }
}
