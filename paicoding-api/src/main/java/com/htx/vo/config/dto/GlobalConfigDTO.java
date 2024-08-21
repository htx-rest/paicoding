package com.htx.vo.config.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:36
 */
@Data
public class GlobalConfigDTO implements Serializable {
    // uid
    private static final long serialVersionUID = 1L;

    // id
    private Long id;
    // 配置项名称
    private String keywords;
    // 配置项值
    private String value;
    // 备注
    private String comment;
}

