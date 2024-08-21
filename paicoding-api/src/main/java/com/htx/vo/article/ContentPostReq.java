package com.htx.vo.article;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 发布文章请求参数
 * @author htx
 * @date 2024/8/20 23:48
 */
@Data
public class ContentPostReq implements Serializable {
    /**
     * 正文内容
     */
    private String content;
}
