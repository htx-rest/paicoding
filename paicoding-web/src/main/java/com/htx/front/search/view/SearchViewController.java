package com.htx.front.search.view;

import com.htx.front.home.helper.IndexRecommendHelper;
import com.htx.front.home.vo.IndexVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 微信搜索「二哈学习之路」
 * 推荐服务接口
 * @author htx
 * @date 2024/8/24 22:31
 */
@Controller
public class SearchViewController {
    @Autowired
    private IndexRecommendHelper indexRecommendHelper;


    /**
     * 查询文章列表
     *
     * @param model
     */
    @GetMapping(path = "search")
    public String searchArticleList(@RequestParam(name = "key") String key, Model model) {
        if (!StringUtils.isBlank(key)) {
            IndexVo vo = indexRecommendHelper.buildSearchVo(key);
            model.addAttribute("vo", vo);
        }
        return "views/article-search-list/index";
    }

}
