package com.htx.comment.converter;

import com.htx.vo.comment.CommentSaveReq;
import com.htx.vo.comment.dto.BaseCommentDTO;
import com.htx.vo.comment.dto.SubCommentDTO;
import com.htx.vo.comment.dto.TopCommentDTO;
import com.htx.comment.repository.entity.CommentDO;

import java.util.ArrayList;

/**
 * 微信搜索「二哈学习之路」
 * 评论转换
 * @author htx
 * @date 2024/8/24 15:45
 */
public class CommentConverter {

    public static CommentDO toDo(CommentSaveReq req) {
        if (req == null) {
            return null;
        }
        CommentDO commentDO = new CommentDO();
        commentDO.setId(req.getCommentId());
        commentDO.setArticleId(req.getArticleId());
        commentDO.setUserId(req.getUserId());
        commentDO.setContent(req.getCommentContent());
        commentDO.setParentCommentId(req.getParentCommentId() == null ? 0L : req.getParentCommentId());
        commentDO.setTopCommentId(req.getTopCommentId() == null ? 0L : req.getTopCommentId());
        return commentDO;
    }

    private static <T extends BaseCommentDTO> void parseDto(CommentDO comment, T sub) {
        sub.setCommentId(comment.getId());
        sub.setUserId(comment.getUserId());
        sub.setCommentContent(comment.getContent());
        sub.setCommentTime(comment.getCreateTime().getTime());
        sub.setPraiseCount(0);
    }

    public static TopCommentDTO toTopDto(CommentDO commentDO) {
        TopCommentDTO dto = new TopCommentDTO();
        parseDto(commentDO, dto);
        dto.setChildComments(new ArrayList<>());
        return dto;
    }

    public static SubCommentDTO toSubDto(CommentDO comment) {
        SubCommentDTO sub = new SubCommentDTO();
        parseDto(comment, sub);
        return sub;
    }
}
