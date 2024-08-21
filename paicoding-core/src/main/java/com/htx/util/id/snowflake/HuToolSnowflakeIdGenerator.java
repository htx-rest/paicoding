package com.htx.util.id.snowflake;

import cn.hutool.core.lang.Snowflake;

import java.util.Date;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 21:35
 */
public class HuToolSnowflakeIdGenerator implements IdGenerator {
    private static final Date EPOC = new Date(2023, 1, 1);
    private Snowflake snowflake;

    public HuToolSnowflakeIdGenerator(int workId, int datacenter) {
        snowflake = new Snowflake(EPOC, workId, datacenter, false);
    }

    @Override
    public Long nextId() {
        return snowflake.nextId();
    }
}
