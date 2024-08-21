package com.htx.vo.article.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:43
 */
@Data
@Accessors(chain = true)
public class SimpleColumnDTO implements Serializable {

    private static final long serialVersionUID = 3646376715620165839L;

    @ApiModelProperty("专栏id")
    private Long columnId;

    @ApiModelProperty("专栏名")
    private String column;

    // 封面
    @ApiModelProperty("封面")
    private String cover;
}
