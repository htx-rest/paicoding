package com.htx.vo.article;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 保存Category请求参数
 * @author htx
 * @date 2024/8/20 23:46
 */
@Data
public class CategoryReq implements Serializable {

    /**
     * ID
     */
    private Long categoryId;

    /**
     * 类目名称
     */
    private String category;

    /**
     * 排序
     */
    private Integer rank;
}
