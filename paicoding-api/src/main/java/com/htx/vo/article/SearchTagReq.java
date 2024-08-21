package com.htx.vo.article;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:51
 */
@Data
public class SearchTagReq {
    // 标签名称
    private String tag;
    // 分页
    private Long pageNumber;
    private Long pageSize;
}
