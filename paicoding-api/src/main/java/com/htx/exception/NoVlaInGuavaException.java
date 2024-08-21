package com.htx.exception;

/**
 * 微信搜索「二哈学习之路」
 * 未命中异常
 * @author htx
 * @date 2024/8/20 22:56
 */
public class NoVlaInGuavaException extends RuntimeException {
    public NoVlaInGuavaException(String msg) {
        super(msg);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
