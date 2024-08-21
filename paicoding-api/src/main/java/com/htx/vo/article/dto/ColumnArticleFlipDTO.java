package com.htx.vo.article.dto;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:39
 */
@Data
public class ColumnArticleFlipDTO {
    String prevHref;
    Boolean prevShow;
    String nextHref;
    Boolean nextShow;
}
