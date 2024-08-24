package com.htx.user.service.relation;

import com.htx.context.ReqInfoContext;
import com.htx.enums.FollowStateEnum;
import com.htx.enums.NotifyTypeEnum;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.notify.NotifyMsgEvent;
import com.htx.vo.user.UserRelationReq;
import com.htx.vo.user.dto.FollowUserInfoDTO;
import com.htx.util.MapUtils;
import com.htx.util.SpringUtil;
import com.htx.user.converter.UserConverter;
import com.htx.user.repository.dao.UserRelationDao;
import com.htx.user.repository.entity.UserRelationDO;
import com.htx.user.service.UserRelationService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 微信搜索「二哈学习之路」
 * 用户关系Service
 * @author htx
 * @date 2024/8/24 15:35
 */
@Service
public class UserRelationServiceImpl implements UserRelationService {
    @Resource
    private UserRelationDao userRelationDao;


    /**
     * 查询用户的关注列表
     *
     * @param userId
     * @param pageParam
     * @return
     */
    @Override
    public PageListVo<FollowUserInfoDTO> getUserFollowList(Long userId, PageParam pageParam) {
        List<FollowUserInfoDTO> userRelationList = userRelationDao.listUserFollows(userId, pageParam);
        return PageListVo.newVo(userRelationList, pageParam.getPageSize());
    }

    @Override
    public PageListVo<FollowUserInfoDTO> getUserFansList(Long userId, PageParam pageParam) {
        List<FollowUserInfoDTO> userRelationList = userRelationDao.listUserFans(userId, pageParam);
        return PageListVo.newVo(userRelationList, pageParam.getPageSize());
    }

    @Override
    public void updateUserFollowRelationId(PageListVo<FollowUserInfoDTO> followList, Long loginUserId) {
        if (loginUserId == null) {
            followList.getList().forEach(r -> {
                r.setRelationId(null);
                r.setFollowed(false);
            });
            return;
        }

        // 判断登录用户与给定的用户列表的关注关系
        Set<Long> userIds = followList.getList().stream().map(FollowUserInfoDTO::getUserId).collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(userIds)) {
            return;
        }

        List<UserRelationDO> relationList = userRelationDao.listUserRelations(loginUserId, userIds);
        Map<Long, UserRelationDO> relationMap = MapUtils.toMap(relationList, UserRelationDO::getUserId, r -> r);
        followList.getList().forEach(follow -> {
            UserRelationDO relation = relationMap.get(follow.getUserId());
            if (relation == null) {
                follow.setRelationId(null);
                follow.setFollowed(false);
            } else if (Objects.equals(relation.getFollowState(), FollowStateEnum.FOLLOW.getCode())) {
                follow.setRelationId(relation.getId());
                follow.setFollowed(true);
            } else {
                follow.setRelationId(relation.getId());
                follow.setFollowed(false);
            }
        });
    }

    /**
     * 根据登录用户从给定用户列表中，找出已关注的用户id
     *
     * @param userIds    主用户列表
     * @param fansUserId 粉丝用户id
     * @return 返回fansUserId已经关注过的用户id列表
     */
    @Override
    public Set<Long> getFollowedUserId(List<Long> userIds, Long fansUserId) {
        if (CollectionUtils.isEmpty(userIds)) {
            return Collections.emptySet();
        }

        List<UserRelationDO> relationList = userRelationDao.listUserRelations(fansUserId, userIds);
        Map<Long, UserRelationDO> relationMap = MapUtils.toMap(relationList, UserRelationDO::getUserId, r -> r);
        return relationMap.values().stream().filter(s -> s.getFollowState().equals(FollowStateEnum.FOLLOW.getCode())).map(UserRelationDO::getUserId).collect(Collectors.toSet());
    }

    @Override
    public void saveUserRelation(UserRelationReq req) {
        // 查询是否存在
        UserRelationDO userRelationDO = userRelationDao.getUserRelationRecord(req.getUserId(), ReqInfoContext.getReqInfo().getUserId());
        if (userRelationDO == null) {
            userRelationDO = UserConverter.toDO(req);
            userRelationDao.save(userRelationDO);
            // 发布关注事件
            SpringUtil.publishEvent(new NotifyMsgEvent<>(this, NotifyTypeEnum.FOLLOW, userRelationDO));
            return;
        }

        // 将是否关注状态重置
        userRelationDO.setFollowState(req.getFollowed() ? FollowStateEnum.FOLLOW.getCode() : FollowStateEnum.CANCEL_FOLLOW.getCode());
        userRelationDao.updateById(userRelationDO);
        // 发布关注、取消关注事件
        SpringUtil.publishEvent(new NotifyMsgEvent<>(this, req.getFollowed() ? NotifyTypeEnum.FOLLOW : NotifyTypeEnum.CANCEL_FOLLOW, userRelationDO));
    }
}
