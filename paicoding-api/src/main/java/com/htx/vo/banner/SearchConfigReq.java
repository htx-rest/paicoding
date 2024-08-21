package com.htx.vo.banner;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/21 20:11
 */
@Data
public class SearchConfigReq {
    /**
     * 类型
     */
    private Integer type;

    /**
     * 名称
     */
    private String name;

    /**
     * 分页
     */
    private Long pageNumber;
    private Long pageSize;

}
