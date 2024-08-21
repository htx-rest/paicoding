package com.htx.dal;

import com.github.hui.quick.plugin.qrcode.util.ClassUtils;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 23:03
 */
public class DruidCheckUtil {

    /**
     * 判断是否包含durid相关的数据包
     *
     * @return
     */
    public static boolean hasDuridPkg() {
        return ClassUtils.isPresent("com.alibaba.druid.pool.DruidDataSource", DataSourceConfig.class.getClassLoader());
    }

}
