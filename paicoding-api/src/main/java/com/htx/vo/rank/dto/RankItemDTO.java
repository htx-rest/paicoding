package com.htx.vo.rank.dto;

import com.htx.vo.user.dto.SimpleUserInfoDTO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 微信搜索「二哈学习之路」
 * 排行榜信息
 * @author htx
 * @date 2024/8/21 20:39
 */
@Data
@Accessors(chain = true)
public class RankItemDTO {

    /**
     * 排名
     */
    private Integer rank;

    /**
     * 评分
     */
    private Integer score;

    /**
     * 用户
     */
    private SimpleUserInfoDTO user;
}
