package com.htx.vo.article;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 保存Tag请求参数
 * @author htx
 * @date 2024/8/20 23:53
 */
@Data
public class TagReq implements Serializable {

    /**
     * ID
     */
    private Long tagId;

    /**
     * 标签名称
     */
    private String tag;

    /**
     * 类目ID
     */
    private Long categoryId;
}
