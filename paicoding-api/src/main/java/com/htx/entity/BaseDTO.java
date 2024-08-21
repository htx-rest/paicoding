package com.htx.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 22:17
 */
@Data
public class BaseDTO {
    @ApiModelProperty(value = "业务主键")
    private Long id;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "最后编辑时间")
    private Date updateTime;
}
