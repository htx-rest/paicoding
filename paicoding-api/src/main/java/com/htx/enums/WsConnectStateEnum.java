package com.htx.enums;

/**
 * 微信搜索「二哈学习之路」
 * websocket 连接 状态
 * @author htx
 * @date 2024/8/20 22:50
 */
public enum WsConnectStateEnum {
    // 初始化
    INIT,
    // 连接中
    CONNECTING,
    // 已连接
    CONNECTED,
    // 连接失败
    FAILED,
    // 已关闭
    CLOSED,
    ;
}
