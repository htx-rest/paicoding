package com.htx.user.service;

import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.user.UserRelationReq;
import com.htx.vo.user.dto.FollowUserInfoDTO;

import java.util.List;
import java.util.Set;

/**
 * 微信搜索「二哈学习之路」
 * 用户关系Service接口
 * @author htx
 * @date 2024/8/24 15:27
 */
public interface UserRelationService {

    /**
     * 我关注的用户
     *
     * @param userId
     * @param pageParam
     * @return
     */
    PageListVo<FollowUserInfoDTO> getUserFollowList(Long userId, PageParam pageParam);


    /**
     * 关注我的粉丝
     *
     * @param userId
     * @param pageParam
     * @return
     */
    PageListVo<FollowUserInfoDTO> getUserFansList(Long userId, PageParam pageParam);

    /**
     * 更新当前登录用户与列表中的用户的关注关系
     *
     * @param followList
     * @param loginUserId
     */
    void updateUserFollowRelationId(PageListVo<FollowUserInfoDTO> followList, Long loginUserId);

    /**
     * 根据登录用户从给定用户列表中，找出已关注的用户id
     *
     * @param userIds
     * @param loginUserId
     * @return
     */
    Set<Long> getFollowedUserId(List<Long> userIds, Long loginUserId);

    /**
     * 保存用户关系: 关注or取消关注
     *
     * @param req
     * @throws Exception
     */
    void saveUserRelation(UserRelationReq req);
}
