package com.htx.article.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 * 类目管理表
 * @author htx
 * @date 2024/8/22 20:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("category")
public class CategoryDO extends BaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 状态：0-未发布，1-已发布
     */
    private Integer status;

    /**
     * 排序
     */
    @TableField("`rank`")
    private Integer rank;

    private Integer deleted;
}
