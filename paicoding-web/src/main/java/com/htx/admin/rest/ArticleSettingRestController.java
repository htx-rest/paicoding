package com.htx.admin.rest;

import com.htx.context.ReqInfoContext;
import com.htx.enums.OperateArticleEnum;
import com.htx.vo.PageVo;
import com.htx.vo.ResVo;
import com.htx.vo.article.ArticlePostReq;
import com.htx.vo.article.SearchArticleReq;
import com.htx.vo.article.dto.ArticleAdminDTO;
import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.article.dto.SimpleArticleDTO;
import com.htx.vo.constants.StatusEnum;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.util.NumUtil;
import com.htx.article.service.ArticleReadService;
import com.htx.article.service.ArticleSettingService;
import com.htx.article.service.ArticleWriteService;
import com.htx.front.search.vo.SearchArticleVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 文章后台
 * @author htx
 * @date 2024/8/24 22:15
 */
@RestController
@Permission(role = UserRole.LOGIN)
@Api(value = "文章设置管理控制器", tags = "文章管理")
@RequestMapping(path = {"/api/admin/article/", "/admin/article/"})
public class ArticleSettingRestController {

    @Autowired
    private ArticleSettingService articleSettingService;

    @Autowired
    private ArticleReadService articleReadService;

    @Autowired
    private ArticleWriteService articleWriteService;

    @Permission(role = UserRole.ADMIN)
    @PostMapping(path = "save")
    public ResVo<String> save(@RequestBody ArticlePostReq req) {
        if (NumUtil.nullOrZero(req.getArticleId())) {
            // 新增文章
            this.articleWriteService.saveArticle(req, ReqInfoContext.getReqInfo().getUserId());
        } else {
            this.articleWriteService.saveArticle(req, null);
        }
        return ResVo.ok();
    }

    @Permission(role = UserRole.ADMIN)
    @PostMapping(path = "update")
    public ResVo<String> update(@RequestBody ArticlePostReq req) {
        articleSettingService.updateArticle(req);
        return ResVo.ok();
    }

    @Permission(role = UserRole.ADMIN)
    @GetMapping(path = "operate")
    public ResVo<String> operate(@RequestParam(name = "articleId") Long articleId, @RequestParam(name = "operateType") Integer operateType) {
        OperateArticleEnum operate = OperateArticleEnum.fromCode(operateType);
        if (operate == OperateArticleEnum.EMPTY) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, operateType + "非法");
        }
        articleSettingService.operateArticle(articleId, operate);
        return ResVo.ok();
    }


    @Permission(role = UserRole.ADMIN)
    @GetMapping(path = "delete")
    public ResVo<String> delete(@RequestParam(name = "articleId") Long articleId) {
        articleSettingService.deleteArticle(articleId);
        return ResVo.ok();
    }

    // 根据文章id获取文章详情
    @ApiOperation("根据文章id获取文章详情")
    @GetMapping(path = "detail")
    public ResVo<ArticleDTO> detail(@RequestParam(name = "articleId", required = false) Long articleId) {
        ArticleDTO articleDTO = new ArticleDTO();
        if (articleId != null) {
            // 查询文章详情
            articleDTO = articleReadService.queryDetailArticleInfo(articleId);
        }

        return ResVo.ok(articleDTO);
    }

    @ApiOperation("获取文章列表")
    @PostMapping(path = "list")
    public ResVo<PageVo<ArticleAdminDTO>> list(@RequestBody SearchArticleReq req) {
        PageVo<ArticleAdminDTO> articleDTOPageVo = articleSettingService.getArticleList(req);
        return ResVo.ok(articleDTOPageVo);
    }

    @ApiOperation("文章搜索")
    @GetMapping(path = "query")
    public ResVo<SearchArticleVo> queryArticleList(@RequestParam(name = "key", required = false) String key) {
        List<SimpleArticleDTO> list = articleReadService.querySimpleArticleBySearchKey(key);
        SearchArticleVo vo = new SearchArticleVo();
        vo.setKey(key);
        vo.setItems(list);
        return ResVo.ok(vo);
    }

}
