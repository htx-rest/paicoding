package com.htx.vo.article;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:50
 */
@Data
@ApiModel("教程配套文章查询")
public class SearchColumnArticleReq {

    // 教程名称
    @ApiModelProperty("教程名称")
    private String column;

    // 教程 ID
    @ApiModelProperty("教程 ID")
    private Long columnId;

    // 文章标题
    @ApiModelProperty("文章标题")
    private String articleTitle;

    @ApiModelProperty("请求页数，从1开始计数")
    private long pageNumber;

    @ApiModelProperty("请求页大小，默认为 10")
    private long pageSize;
}
