package com.htx.front.article.rest;

import com.htx.vo.NextPageHtmlVo;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.ResVo;
import com.htx.vo.article.dto.ColumnDTO;
import com.htx.vo.article.dto.SimpleArticleDTO;
import com.htx.article.service.ColumnService;
import com.htx.component.TemplateEngineHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:47
 */
@RestController
@RequestMapping(path = "column/api")
public class ColumnRestController {
    @Autowired
    private ColumnService columnService;

    @Autowired
    private TemplateEngineHelper templateEngineHelper;

    /**
     * 翻页的专栏列表
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping(path = "list")
    public ResVo<NextPageHtmlVo> list(@RequestParam(name = "page") Long page,
                                      @RequestParam(name = "size", required = false) Long size) {
        if (page <= 0) {
            page = 1L;
        }
        size = Optional.ofNullable(size).orElse(PageParam.DEFAULT_PAGE_SIZE);
        size = Math.min(size, PageParam.DEFAULT_PAGE_SIZE);
        PageListVo<ColumnDTO> list = columnService.listColumn(PageParam.newPageInstance(page, size));

        String html = templateEngineHelper.renderToVo("biz/column/list", "columns", list);
        return ResVo.ok(new NextPageHtmlVo(html, list.getHasMore()));
    }

    /**
     * 详情页的菜单栏(即专栏的文章列表)
     *
     * @param columnId
     * @return
     */
    @GetMapping(path = "menu/{column}")
    public ResVo<NextPageHtmlVo> columnMenus(@PathVariable("column") Long columnId) {
        List<SimpleArticleDTO> articleList = columnService.queryColumnArticles(columnId);
        String html = templateEngineHelper.renderToVo("biz/column/menus", "menu", articleList);
        return ResVo.ok(new NextPageHtmlVo(html, false));
    }
}
