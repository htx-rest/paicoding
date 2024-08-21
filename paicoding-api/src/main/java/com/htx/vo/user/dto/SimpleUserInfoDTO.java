package com.htx.vo.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 基本用户信息
 * @author htx
 * @date 2024/8/21 20:24
 */
@Data
@Accessors(chain = true)
public class SimpleUserInfoDTO implements Serializable {
    private static final long serialVersionUID = 4802653694786272120L;

    @ApiModelProperty("作者ID")
    private Long userId;

    @ApiModelProperty("作者名")
    private String name;

    @ApiModelProperty("作者头像")
    private String avatar;

    @ApiModelProperty("作者简介")
    private String profile;
}
