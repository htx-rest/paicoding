package com.htx.vo.rank.dto;

import com.htx.enums.rank.ActivityRankTimeEnum;
import lombok.Data;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 排行榜信息
 * @author htx
 * @date 2024/8/21 20:38
 */
@Data
public class RankInfoDTO {
    private ActivityRankTimeEnum time;
    private List<RankItemDTO> items;
}
