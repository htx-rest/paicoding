package com.htx.exception;

import com.htx.vo.Status;
import com.htx.vo.constants.StatusEnum;
import lombok.Getter;

/**
 * 微信搜索「二哈学习之路」
 * 业务异常
 * @author htx
 * @date 2024/8/20 22:54
 */
public class ForumAdviceException extends RuntimeException {
    @Getter
    private Status status;

    public ForumAdviceException(Status status) {
        this.status = status;
    }

    public ForumAdviceException(int code, String msg) {
        this.status = Status.newStatus(code, msg);
    }

    public ForumAdviceException(StatusEnum statusEnum, Object... args) {
        this.status = Status.newStatus(statusEnum, args);
    }

}
