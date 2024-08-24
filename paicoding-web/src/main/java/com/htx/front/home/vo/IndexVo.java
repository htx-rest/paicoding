package com.htx.front.home.vo;

import com.htx.vo.PageListVo;
import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.article.dto.CategoryDTO;
import com.htx.vo.recommend.CarouseDTO;
import com.htx.vo.recommend.SideBarDTO;
import com.htx.vo.user.dto.UserStatisticInfoDTO;
import lombok.Data;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:36
 */
@Data
public class IndexVo {
    /**
     * 分类列表
     */
    private List<CategoryDTO> categories;

    /**
     * 当前选中的分类
     */
    private String currentCategory;

    /**
     * 当前选中的类目id
     */
    private Long categoryId;

    /**
     * top 文章列表
     */
    private List<ArticleDTO> topArticles;

    /**
     * 文章列表
     */
    private PageListVo<ArticleDTO> articles;

    /**
     * 登录用户信息
     */
    private UserStatisticInfoDTO user;

    /**
     * 侧边栏信息
     */
    private  List<SideBarDTO> sideBarItems;

    /**
     * 轮播图
     */
    private List<CarouseDTO> homeCarouselList;
}
