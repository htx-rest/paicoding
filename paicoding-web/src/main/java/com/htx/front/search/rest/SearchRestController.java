package com.htx.front.search.rest;

import com.htx.vo.NextPageHtmlVo;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.ResVo;
import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.article.dto.SimpleArticleDTO;
import com.htx.article.service.ArticleReadService;
import com.htx.component.TemplateEngineHelper;
import com.htx.front.search.vo.SearchArticleVo;
import com.htx.global.BaseViewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 推荐服务接口
 * @author htx
 * @date 2024/8/24 22:32
 */
@RequestMapping(path = "search/api")
@RestController
public class SearchRestController extends BaseViewController {

    @Autowired
    private ArticleReadService articleReadService;

    @Autowired
    private TemplateEngineHelper templateEngineHelper;

    /**
     * 根据关键词给出搜索下拉框
     *
     * @param key
     */
    @GetMapping(path = "hint")
    public ResVo<SearchArticleVo> recommend(@RequestParam(name = "key", required = false) String key) {List<SimpleArticleDTO> list = articleReadService.querySimpleArticleBySearchKey(key);
        SearchArticleVo vo = new SearchArticleVo();
        vo.setKey(key);
        vo.setItems(list);
        return ResVo.ok(vo);
    }


    /**
     * 分类下的文章列表
     *
     * @param key
     * @return
     */
    @GetMapping(path = "list")
    public ResVo<NextPageHtmlVo> searchList(@RequestParam(name = "key", required = false) String key,
                                            @RequestParam(name = "page") Long page,
                                            @RequestParam(name = "size", required = false) Long size) {
        PageParam pageParam = buildPageParam(page, size);
        PageListVo<ArticleDTO> list = articleReadService.queryArticlesBySearchKey(key, pageParam);
        String html = templateEngineHelper.renderToVo("views/article-search-list/article/list", "articles", list);
        return ResVo.ok(new NextPageHtmlVo(html, list.getHasMore()));
    }
}
