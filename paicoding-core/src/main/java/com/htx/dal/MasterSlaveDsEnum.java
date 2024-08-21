package com.htx.dal;

/**
 * 微信搜索「二哈学习之路」
 * 主从数据源的枚举
 * @author htx
 * @date 2024/8/21 22:57
 */
public enum MasterSlaveDsEnum implements DS {
    /**
     * master主数据源类型
     */
    MASTER,
    /**
     * slave从数据源类型
     */
    SLAVE;
}
