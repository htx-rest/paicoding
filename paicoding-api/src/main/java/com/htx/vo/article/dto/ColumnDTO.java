package com.htx.vo.article.dto;

import com.htx.enums.column.ColumnStatusEnum;
import com.htx.enums.column.ColumnTypeEnum;
import com.htx.vo.user.dto.ColumnFootCountDTO;
import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:41
 */
@Data
public class ColumnDTO {

    /**
     * 专栏id
     */
    private Long columnId;

    /**
     * 专栏名
     */
    private String column;

    /**
     * 说明
     */
    private String introduction;

    /**
     * 封面
     */
    private String cover;

    /**
     * 发布时间
     */
    private Long publishTime;

    /**
     * 排序
     */
    private Integer section;

    /**
     * 0 未发布 1 连载 2 完结
     *
     * @see ColumnStatusEnum#getCode()
     */
    private Integer state;

    /**
     * 专栏预计的文章数
     */
    private Integer nums;

    /**
     * 专栏类型
     *
     * @see ColumnTypeEnum#getType()
     */
    private Integer type;

    /**
     * 限时免费开始时间
     */
    private Long freeStartTime;

    /**
     * 限时免费结束时间
     */
    private Long freeEndTime;

    /**
     * 作者
     */
    private Long author;

    /**
     * 作者名
     */
    private String authorName;

    /**
     * 作者头像
     */
    private String authorAvatar;

    /**
     * 个人简介
     */
    private String authorProfile;

    /**
     * 统计计数相关信息
     */
    private ColumnFootCountDTO count;
}