package com.htx.user.service;

import com.htx.vo.user.UserPwdLoginReq;

/**
 * 微信搜索「二哈学习之路」
 * 用户注册服务
 * @author htx
 * @date 2024/8/24 15:24
 */
public interface RegisterService {
    /**
     * 通过用户名/密码进行注册
     *
     * @param loginReq
     * @return
     */
    Long registerByUserNameAndPassword(UserPwdLoginReq loginReq);

    /**
     * 通过微信公众号进行注册
     *
     * @param thirdAccount
     * @return
     */
    Long registerByWechat(String thirdAccount);
}
