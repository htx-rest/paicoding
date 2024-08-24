package com.htx.front.test.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 邮件发送验证
 * @author htx
 * @date 2024/8/24 22:53
 */
@Data
public class EmailReqVo implements Serializable {
    private static final long serialVersionUID = -8560585303684975482L;

    private String to;

    private String title;

    private String content;

}
