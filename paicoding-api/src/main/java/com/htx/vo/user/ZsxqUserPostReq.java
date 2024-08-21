package com.htx.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:19
 */
@Data
public class ZsxqUserPostReq implements Serializable {
    // id
    private Long id;
    // 用户名
    private String userCode;
    // 用户昵称
    private String name;
    // 星球编号
    private String starNumber;
    // AI 策略
    private Integer strategy;
}
