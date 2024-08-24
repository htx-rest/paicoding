package com.htx.front.user.vo;

import com.htx.enums.FollowSelectEnum;
import com.htx.vo.PageListVo;
import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.article.dto.TagSelectDTO;
import com.htx.vo.user.dto.FollowUserInfoDTO;
import com.htx.vo.user.dto.UserStatisticInfoDTO;
import lombok.Data;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:49
 */
@Data
public class UserHomeVo {
    private String homeSelectType;
    private List<TagSelectDTO> homeSelectTags;
    /**
     * 关注列表/粉丝列表
     */
    private PageListVo<FollowUserInfoDTO> followList;
    /**
     * @see FollowSelectEnum#getCode()
     */
    private String followSelectType;
    private List<TagSelectDTO> followSelectTags;
    private UserStatisticInfoDTO userHome;

    /**
     * 文章列表
     */
    private PageListVo<ArticleDTO> homeSelectList;
}
