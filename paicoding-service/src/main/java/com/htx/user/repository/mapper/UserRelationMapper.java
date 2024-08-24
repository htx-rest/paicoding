package com.htx.user.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.vo.PageParam;
import com.htx.vo.user.dto.FollowUserInfoDTO;
import com.htx.user.repository.entity.UserRelationDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 用户关系mapper接口
 * @author htx
 * @date 2024/8/24 15:20
 */
public interface UserRelationMapper extends BaseMapper<UserRelationDO> {

    /**
     * 我关注的用户
     * @param followUserId
     * @param pageParam
     * @return
     */
    List<FollowUserInfoDTO> queryUserFollowList(@Param("followUserId") Long followUserId, @Param("pageParam") PageParam pageParam);

    /**
     * 关注我的粉丝
     * @param userId
     * @param pageParam
     * @return
     */
    List<FollowUserInfoDTO> queryUserFansList(@Param("userId") Long userId, @Param("pageParam") PageParam pageParam);
}
