package com.htx.user.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.htx.vo.PageParam;
import com.htx.vo.user.dto.ZsxqUserInfoDTO;
import com.htx.user.repository.entity.UserAiDO;
import com.htx.user.repository.params.SearchZsxqWhiteParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * ai用户登录mapper接口
 * @author htx
 * @date 2024/8/24 15:17
 */
public interface UserAiMapper extends BaseMapper<UserAiDO> {

    Long countZsxqUsersByParams(@Param("searchParams") SearchZsxqWhiteParams params);

    List<ZsxqUserInfoDTO> listZsxqUsersByParams(@Param("searchParams") SearchZsxqWhiteParams params,
                                                @Param("pageParam") PageParam newPageInstance);
}
