package com.htx.exception;

import com.htx.vo.Status;
import com.htx.vo.constants.StatusEnum;
import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 业务异常
 * @author htx
 * @date 2024/8/20 22:55
 */
public class ForumException extends RuntimeException {
    @Getter
    private Status status;

    public ForumException(Status status) {
        this.status = status;
    }

    public ForumException(int code, String msg) {
        this.status = Status.newStatus(code, msg);
    }

    public ForumException(StatusEnum statusEnum, Object... args) {
        this.status = Status.newStatus(statusEnum, args);
    }

}
