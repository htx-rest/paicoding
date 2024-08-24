package com.htx.article.repository.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.htx.entity.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 微信搜索「二哈学习之路」
 * fixme 访问计数，后续改用redis替换
 * @author htx
 * @date 2024/8/22 20:33
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("read_count")
public class ReadCountDO extends BaseDO {
    /**
     * 文档ID（文章/评论）
     */
    private Long documentId;

    /**
     * 文档类型：1-文章，2-评论
     */
    private Integer documentType;

    /**
     * 计数
     */
    private Integer cnt;

}
