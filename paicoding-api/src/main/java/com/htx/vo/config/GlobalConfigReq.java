package com.htx.vo.config;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:35
 */
@Data
public class GlobalConfigReq {
    // 配置项名称
    private String keywords;
    // 配置项值
    private String value;
    // 备注
    private String comment;
    // id
    private Long id;
}
