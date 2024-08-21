package com.htx.autoconf;

import com.htx.autoconf.property.SpringValueRegistry;
import com.htx.event.ConfigRefreshEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 微信搜索「二哈学习之路」
 * 配置刷新事件监听
 * @author htx
 * @date 2024/8/21 22:32
 */
@Service
public class ConfigRefreshEventListener implements ApplicationListener<ConfigRefreshEvent> {
    @Autowired
    private DynamicConfigContainer dynamicConfigContainer;

    /**
     * 监听配置变更事件
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ConfigRefreshEvent event) {
        dynamicConfigContainer.reloadConfig();
        SpringValueRegistry.updateValue(event.getKey());
    }
}
