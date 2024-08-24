package com.htx.front.search.vo;

import com.htx.vo.article.dto.SimpleArticleDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:29
 */
@Data
@ApiModel(value="文章信息")
public class SearchArticleVo implements Serializable {
    private static final long serialVersionUID = -2989169905031769195L;

    @ApiModelProperty("搜索的关键词")
    private String key;

    @ApiModelProperty("文章列表")
    private List<SimpleArticleDTO> items;
}
