package com.htx.vo.user;

import lombok.Data;

/**
 * 微信搜索「二哈学习之路」
 * 用户关系入参
 * @author htx
 * @date 2024/8/21 20:17
 */
@Data
public class UserRelationReq {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 粉丝用户ID
     */
    private Long followUserId;

    /**
     * 是否关注当前用户
     */
    private Boolean followed;
}
