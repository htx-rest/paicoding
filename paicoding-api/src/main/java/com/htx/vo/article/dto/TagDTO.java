package com.htx.vo.article.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:44
 */
@Data
public class TagDTO implements Serializable {
    private static final long serialVersionUID = -8614833588325787479L;

    private Long tagId;

    private String tag;

    private Integer status;

    private Boolean selected;
}
