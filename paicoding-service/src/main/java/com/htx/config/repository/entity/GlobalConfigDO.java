package com.htx.config.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 微信搜索「二哈学习之路」
 * 评论表
 * @author htx
 * @date 2024/8/24 16:22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("global_conf")
public class GlobalConfigDO extends BaseDO {
    private static final long serialVersionUID = -6122208316544171301L;

    // 配置项名称
    @TableField("`key`")
    private String key;
    // 配置项值
    private String value;
    // 备注
    private String comment;
    // 删除
    private Integer deleted;
}
