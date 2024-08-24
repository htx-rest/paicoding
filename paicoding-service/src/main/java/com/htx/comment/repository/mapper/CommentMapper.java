package com.htx.comment.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.comment.repository.entity.CommentDO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 * 评论mapper接口
 * @author htx
 * @date 2024/8/24 15:49
 */
public interface CommentMapper extends BaseMapper<CommentDO> {
    Map<String, Object> getHotTopCommentId(@Param("articleId") Long articleId);

}
