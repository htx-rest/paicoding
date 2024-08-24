package com.htx.user.service;

import com.htx.enums.user.UserAIStatEnum;
import com.htx.vo.PageVo;
import com.htx.vo.user.SearchZsxqUserReq;
import com.htx.vo.user.ZsxqUserPostReq;
import com.htx.vo.user.dto.ZsxqUserInfoDTO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 15:28
 */
public interface ZsxqWhiteListService {
    PageVo<ZsxqUserInfoDTO> getList(SearchZsxqUserReq req);

    void operate(Long id, UserAIStatEnum operate);

    void update(ZsxqUserPostReq req);

    void batchOperate(List<Long> ids, UserAIStatEnum operate);

    void reset(Integer authorId);
}
