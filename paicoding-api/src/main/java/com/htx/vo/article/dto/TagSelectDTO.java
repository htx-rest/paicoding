package com.htx.vo.article.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 通用标签选择
 * @author htx
 * @date 2024/8/20 23:45
 */
@Data
public class TagSelectDTO implements Serializable {

    /**
     * 类型
     */
    private String selectType;

    /**
     * 描述
     */
    private String selectDesc;

    /**
     * 是否选中
     */
    private Boolean selected;
}
