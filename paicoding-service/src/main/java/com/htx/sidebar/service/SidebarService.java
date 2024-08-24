package com.htx.sidebar.service;

import com.htx.vo.recommend.SideBarDTO;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 16:08
 */
public interface SidebarService {

    /**
     * 查询首页的侧边栏信息
     *
     * @return
     */
    List<SideBarDTO> queryHomeSidebarList();

    /**
     * 查询教程的侧边栏信息
     *
     * @return
     */
    List<SideBarDTO> queryColumnSidebarList();

    /**
     * 查询文章详情的侧边栏信息
     *
     * @param author    文章作者id
     * @param articleId 文章id
     * @return
     */
    List<SideBarDTO> queryArticleDetailSidebarList(Long author, Long articleId);

}
