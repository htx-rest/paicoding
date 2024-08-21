package com.htx.dal;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 23:05
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DsContextHolder.get();
    }

}
