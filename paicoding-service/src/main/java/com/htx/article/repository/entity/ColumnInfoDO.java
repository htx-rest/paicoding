package com.htx.article.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import com.htx.enums.column.ColumnStatusEnum;
import com.htx.enums.column.ColumnTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/22 20:32
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("column_info")
public class ColumnInfoDO extends BaseDO {

    private static final long serialVersionUID = 1920830534262012026L;
    /**
     * 专栏名
     */
    private String columnName;

    /**
     * 作者
     */
    private Long userId;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 封面
     */
    private String cover;

    /**
     * 状态
     *
     * @see ColumnStatusEnum#getCode()
     */
    private Integer state;

    /**
     * 排序
     */
    private Integer section;

    /**
     * 上线时间
     */
    private Date publishTime;

    /**
     * 专栏预计的文章数
     */
    private Integer nums;

    /**
     * 专栏类型：免费、登录阅读、收费阅读等
     * @see ColumnTypeEnum#getType()
     */
    private Integer type;

    /**
     * 免费开始时间
     */
    private Date freeStartTime;

    /**
     * 免费结束时间
     */
    private Date freeEndTime;
}
