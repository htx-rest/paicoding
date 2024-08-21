package com.htx.exception;

import com.htx.vo.constants.StatusEnum;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 22:54
 */
public class ExceptionUtil {

    public static ForumException of(StatusEnum status, Object... args) {
        return new ForumException(status, args);
    }

}
