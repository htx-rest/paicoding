package com.htx.enums.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 星球来源枚举
 * @author htx
 * @date 2024/8/20 22:26
 */
@Getter
@AllArgsConstructor
public enum StarSourceEnum {
    /**
     * java进阶
     */
    JAVA_GUIDE(1),
    /**
     * 技术派
     */
    TECH_PAI(2),
    ;
    private int source;
}

