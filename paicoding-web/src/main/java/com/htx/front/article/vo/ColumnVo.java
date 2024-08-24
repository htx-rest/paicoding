package com.htx.front.article.vo;

import com.htx.vo.PageListVo;
import com.htx.vo.article.dto.ColumnDTO;
import com.htx.vo.recommend.SideBarDTO;
import lombok.Data;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:39
 */
@Data
public class ColumnVo {
    /**
     * 专栏列表
     */
    private PageListVo<ColumnDTO> columns;

    /**
     * 侧边栏信息
     */
    private List<SideBarDTO> sideBarItems;

}
