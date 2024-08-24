package com.htx.config.service.impl;

import com.htx.event.ConfigRefreshEvent;
import com.htx.exception.ExceptionUtil;
import com.htx.vo.PageVo;
import com.htx.vo.config.GlobalConfigReq;
import com.htx.vo.config.SearchGlobalConfigReq;
import com.htx.vo.config.dto.GlobalConfigDTO;
import com.htx.vo.constants.StatusEnum;
import com.htx.senstive.SensitiveProperty;
import com.htx.senstive.SensitiveService;
import com.htx.util.NumUtil;
import com.htx.util.SpringUtil;
import com.htx.config.converter.ConfigStructMapper;
import com.htx.config.repository.dao.ConfigDao;
import com.htx.config.repository.entity.GlobalConfigDO;
import com.htx.config.repository.params.SearchGlobalConfigParams;
import com.htx.config.service.GlobalConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 20:52
 */
@Service
public class GlobalConfigServiceImpl implements GlobalConfigService {
    @Autowired
    private ConfigDao configDao;

    @Override
    public PageVo<GlobalConfigDTO> getList(SearchGlobalConfigReq req) {
        ConfigStructMapper mapper = ConfigStructMapper.INSTANCE;
        // 转换
        SearchGlobalConfigParams params = mapper.toSearchGlobalParams(req);
        // 查询
        List<GlobalConfigDO> list = configDao.listGlobalConfig(params);
        // 总数
        Long total = configDao.countGlobalConfig(params);

        return PageVo.build(mapper.toGlobalDTOS(list), params.getPageSize(), params.getPageNum(), total);
    }

    @Override
    public void save(GlobalConfigReq req) {
        GlobalConfigDO globalConfigDO = ConfigStructMapper.INSTANCE.toGlobalDO(req);
        // id 不为空
        if (NumUtil.nullOrZero(globalConfigDO.getId())) {
            configDao.save(globalConfigDO);
        } else {
            configDao.updateById(globalConfigDO);
        }

        // 配置更新之后，主动触发配置的动态加载
        SpringUtil.publishEvent(new ConfigRefreshEvent(this, req.getKeywords(), req.getValue()));
    }

    @Override
    public void delete(Long id) {
        GlobalConfigDO globalConfigDO = configDao.getGlobalConfigById(id);
        if (globalConfigDO != null) {
            configDao.delete(globalConfigDO);
        } else {
            throw ExceptionUtil.of(StatusEnum.RECORDS_NOT_EXISTS, "记录不存在");
        }
    }

    /**
     * 添加敏感词白名单
     *
     * @param word
     */
    @Override
    public void addSensitiveWhiteWord(String word) {
        String key = SensitiveProperty.SENSITIVE_KEY_PREFIX + ".allow";
        GlobalConfigReq req = new GlobalConfigReq();
        req.setKeywords(key);

        GlobalConfigDO config = configDao.getGlobalConfigByKey(key);
        if (config == null) {
            req.setValue(word);
            req.setComment("敏感词白名单");
        } else {
            req.setValue(config.getValue() + "," + word);
            req.setComment(config.getComment());
            req.setId(config.getId());
        }
        // 更新敏感词白名单
        save(req);

        // 移除敏感词记录
        SpringUtil.getBean(SensitiveService.class).removeSensitiveWord(word);
    }
}
