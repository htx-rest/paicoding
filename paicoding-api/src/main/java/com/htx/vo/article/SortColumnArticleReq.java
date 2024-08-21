package com.htx.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:52
 */
@Data
@ApiModel("教程排序")
public class SortColumnArticleReq implements Serializable {
    // 排序前的文章 ID
    @ApiModelProperty("排序前的文章 ID")
    private Long activeId;

    // 排序后的文章 ID
    @ApiModelProperty("排序后的文章 ID")
    private Long overId;

}
