package com.htx.user.repository.dao;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htx.user.repository.entity.UserAiHistoryDO;
import com.htx.user.repository.mapper.UserAiHistoryMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 15:12
 */
@Repository
public class UserAiHistoryDao extends ServiceImpl<UserAiHistoryMapper, UserAiHistoryDO> {

    @Resource
    private UserAiHistoryMapper userAiHistoryMapper;
}
