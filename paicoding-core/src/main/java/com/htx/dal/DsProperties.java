package com.htx.dal;

import lombok.Data;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 * 多数据源的配置加载
 * @author htx
 * @date 2024/8/21 22:54
 */
@Data
@ConfigurationProperties(prefix = DsProperties.DS_PREFIX)
public class DsProperties {
    public static final String DS_PREFIX = "spring.dynamic";
    /**
     * 默认数据源
     */
    private String primary;

    /**
     * 多数据源配置
     */
    private Map<String, DataSourceProperties> datasource;
}
