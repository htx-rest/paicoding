package com.htx.vo.recommend;

import com.htx.enums.SidebarStyleEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 侧边推广信息
 * @author htx
 * @date 2024/8/21 20:41
 */
@Data
@Accessors(chain = true)
public class SideBarDTO {

    private String title;

    private String subTitle;

    private String icon;

    private String img;

    private String url;

    private String content;

    private List<SideBarItemDTO> items;

    /**
     * 侧边栏样式
     *
     * @see SidebarStyleEnum#getStyle()
     */
    private Integer style;
}
