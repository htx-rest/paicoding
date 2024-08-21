package com.htx.util.id.snowflake;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 21:37
 */
public interface IdGenerator {
    /**
     * 生成分布式id
     *
     * @return
     */
    Long nextId();
}
