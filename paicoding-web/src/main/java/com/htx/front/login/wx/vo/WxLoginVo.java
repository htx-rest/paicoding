package com.htx.front.login.wx.vo;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:58
 */
@Data
public class WxLoginVo {
    /**
     * 验证码
     */
    private String code;

    /**
     * 二维码
     */
    private String qr;

    /**
     * true 表示需要重新建立连接
     */
    private boolean reconnect;

}
