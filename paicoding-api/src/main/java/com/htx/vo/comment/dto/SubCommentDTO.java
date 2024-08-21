package com.htx.vo.comment.dto;

import lombok.Data;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

/**
 * 微信搜索「二哈学习之路」
 * 评论树状结构
 * @author htx
 * @date 2024/8/21 20:32
 */
@ToString(callSuper = true)
@Data
public class SubCommentDTO extends BaseCommentDTO {

    /**
     * 父评论内容
     */
    private String parentContent;


    @Override
    public int compareTo(@NotNull BaseCommentDTO o) {
        return Long.compare(this.getCommentTime(), o.getCommentTime());
    }
}
