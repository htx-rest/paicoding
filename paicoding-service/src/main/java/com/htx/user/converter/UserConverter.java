package com.htx.user.converter;

import com.htx.context.ReqInfoContext;
import com.htx.enums.FollowStateEnum;
import com.htx.enums.RoleEnum;
import com.htx.enums.user.UserAIStatEnum;
import com.htx.vo.user.UserInfoSaveReq;
import com.htx.vo.user.UserRelationReq;
import com.htx.vo.user.UserSaveReq;
import com.htx.vo.user.dto.BaseUserInfoDTO;
import com.htx.vo.user.dto.SimpleUserInfoDTO;
import com.htx.vo.user.dto.UserStatisticInfoDTO;
import com.htx.user.repository.entity.UserAiDO;
import com.htx.user.repository.entity.UserDO;
import com.htx.user.repository.entity.UserInfoDO;
import com.htx.user.repository.entity.UserRelationDO;
import org.springframework.beans.BeanUtils;

/**
 * 微信搜索「二哈学习之路」
 * 用户转换
 * @author htx
 * @date 2024/8/24 15:00
 */
public class UserConverter {

    public static UserDO toDO(UserSaveReq req) {
        if (req == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        userDO.setId(req.getUserId());
        userDO.setThirdAccountId(req.getThirdAccountId());
        userDO.setLoginType(req.getLoginType());
        return userDO;
    }

    public static UserInfoDO toDO(UserInfoSaveReq req) {
        if (req == null) {
            return null;
        }
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserId(req.getUserId());
        userInfoDO.setUserName(req.getUserName());
        userInfoDO.setPhoto(req.getPhoto());
        userInfoDO.setPosition(req.getPosition());
        userInfoDO.setCompany(req.getCompany());
        userInfoDO.setProfile(req.getProfile());
        return userInfoDO;
    }

    public static BaseUserInfoDTO toDTO(UserInfoDO info, UserAiDO userAiDO) {
        BaseUserInfoDTO user = toDTO(info);
        if (userAiDO != null) {
            user.setStarStatus(UserAIStatEnum.fromCode(userAiDO.getState()));
        }
        return user;
    }

    public static BaseUserInfoDTO toDTO(UserInfoDO info) {
        if (info == null) {
            return null;
        }
        BaseUserInfoDTO user = new BaseUserInfoDTO();
        // todo 知识点，bean属性拷贝的几种方式， 直接get/set方式，使用BeanUtil工具类(spring, cglib, apache, objectMapper)，序列化方式等
        BeanUtils.copyProperties(info, user);
        // 设置用户最新登录地理位置
        user.setRegion(info.getIp().getLatestRegion());
        // 设置用户角色
        user.setRole(RoleEnum.role(info.getUserRole()));
        return user;
    }

    public static SimpleUserInfoDTO toSimpleInfo(UserInfoDO info) {
        return new SimpleUserInfoDTO().setUserId(info.getUserId())
                .setName(info.getUserName())
                .setAvatar(info.getPhoto())
                .setProfile(info.getProfile());
    }

    public static UserRelationDO toDO(UserRelationReq req) {
        if (req == null) {
            return null;
        }
        UserRelationDO userRelationDO = new UserRelationDO();
        userRelationDO.setUserId(req.getUserId());
        userRelationDO.setFollowUserId(ReqInfoContext.getReqInfo().getUserId());
        userRelationDO.setFollowState(req.getFollowed() ? FollowStateEnum.FOLLOW.getCode() : FollowStateEnum.CANCEL_FOLLOW.getCode());
        return userRelationDO;
    }

    public static UserStatisticInfoDTO toUserHomeDTO(UserStatisticInfoDTO userHomeDTO, BaseUserInfoDTO baseUserInfoDTO) {
        if (baseUserInfoDTO == null) {
            return null;
        }
        BeanUtils.copyProperties(baseUserInfoDTO, userHomeDTO);
        return userHomeDTO;
    }
}
