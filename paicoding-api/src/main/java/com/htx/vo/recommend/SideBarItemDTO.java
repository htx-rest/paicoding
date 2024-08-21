package com.htx.vo.recommend;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 侧边推广信息
 * @author htx
 * @date 2024/8/21 20:42
 */
@Data
@Accessors(chain = true)
public class SideBarItemDTO {

    private String title;

    private String name;

    private String url;

    private String img;

    private Long time;

    /**
     * tag列表
     */
    private List<Integer> tags;

    /**
     * 评分信息
     */
    private RateVisitDTO visit;
}
