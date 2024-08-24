package com.htx.user.service.help;

import com.htx.user.service.conf.AiConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 微信搜索「二哈学习之路」
 * 密码加密器，后续接入SpringSecurity之后，可以使用 PasswordEncoder 进行替换
 * @author htx
 * @date 2024/8/24 15:31
 */
@Component
public class StarNumberHelper {
    @Resource
    private AiConfig aiConfig;

    public Boolean checkStarNumber(String starNumber) {
        // 判断编号是否在 0 - maxStarNumber 之间
        return Integer.parseInt(starNumber) >= 0 && Integer.parseInt(starNumber) <= aiConfig.getMaxNum().getStarNumber();
    }

}
