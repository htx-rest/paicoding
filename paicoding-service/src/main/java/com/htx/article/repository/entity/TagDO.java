package com.htx.article.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 * 标签管理表
 * @author htx
 * @date 2024/8/22 20:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("tag")
public class TagDO extends BaseDO {
    private static final long serialVersionUID = 3796460143933607644L;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签类型：1-系统标签，2-自定义标签
     */
    private Integer tagType;

    /**
     * 状态：0-未发布，1-已发布
     */
    private Integer status;

    /**
     * 是否删除
     */
    private Integer deleted;
}
