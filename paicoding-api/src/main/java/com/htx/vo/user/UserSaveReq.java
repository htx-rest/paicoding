package com.htx.vo.user;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 微信搜索「二哈学习之路」
 * 用户入参
 * @author htx
 * @date 2024/8/21 20:18
 */
@Data
@Accessors(chain = true)
public class UserSaveReq {
    /**
     * 主键ID
     */
    private Long userId;

    /**
     * 第三方用户ID
     */
    private String thirdAccountId;

    /**
     * 登录方式: 0-微信登录，1-账号密码登录
     */
    private Integer loginType;
}
