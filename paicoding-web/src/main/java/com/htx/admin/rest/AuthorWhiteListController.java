package com.htx.admin.rest;

import com.htx.vo.ResVo;
import com.htx.vo.user.dto.BaseUserInfoDTO;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.user.service.AuthorWhiteListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 作者白名单服务
 * @author htx
 * @date 2024/8/24 22:16
 */
@RestController
@Api(value = "发布文章作者白名单管理控制器", tags = "作者白名单")
@Permission(role = UserRole.ADMIN)
@RequestMapping(path = {"api/admin/author/whitelist"})
public class AuthorWhiteListController {
    @Autowired
    private AuthorWhiteListService articleWhiteListService;

    @GetMapping(path = "get")
    @ApiOperation(value = "白名单列表", notes = "返回作者白名单列表")
    public ResVo<List<BaseUserInfoDTO>> whiteList() {
        return ResVo.ok(articleWhiteListService.queryAllArticleWhiteListAuthors());
    }

    @GetMapping(path = "add")
    @ApiOperation(value = "添加白名单", notes = "将指定作者加入作者白名单列表")
    @ApiImplicitParam(name = "authorId", value = "传入需要添加白名单的作者UserId", required = true, allowEmptyValue = false, example = "1")
    public ResVo<Boolean> addAuthor(@RequestParam("authorId") Long authorId) {
        articleWhiteListService.addAuthor2ArticleWhitList(authorId);
        return ResVo.ok(true);
    }

    @GetMapping(path = "remove")
    @ApiOperation(value = "删除白名单", notes = "将作者从白名单列表")
    @ApiImplicitParam(name = "authorId", value = "传入需要删除白名单的作者UserId", required = true, allowEmptyValue = false, example = "1")
    public ResVo<Boolean> rmAuthor(@RequestParam("authorId") Long authorId) {
        articleWhiteListService.removeAuthorFromArticleWhiteList(authorId);
        return ResVo.ok(true);
    }
}
