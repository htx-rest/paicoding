package com.htx.front.user.rest;

import com.htx.context.ReqInfoContext;
import com.htx.enums.FollowTypeEnum;
import com.htx.enums.HomeSelectEnum;
import com.htx.vo.NextPageHtmlVo;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.ResVo;
import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.constants.StatusEnum;
import com.htx.vo.user.UserInfoSaveReq;
import com.htx.vo.user.UserRelationReq;
import com.htx.vo.user.dto.FollowUserInfoDTO;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.article.service.ArticleReadService;
import com.htx.user.service.relation.UserRelationServiceImpl;
import com.htx.user.service.user.UserServiceImpl;
import com.htx.component.TemplateEngineHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 22:52
 */
@RestController
@RequestMapping(path = "user/api")
public class UserRestController {

    @Resource
    private UserServiceImpl userService;

    @Resource
    private UserRelationServiceImpl userRelationService;

    @Resource
    private TemplateEngineHelper templateEngineHelper;


    @Resource
    private ArticleReadService articleReadService;


    /**
     * 保存用户关系
     *
     * @param req
     * @return
     * @throws Exception
     */
    @Permission(role = UserRole.LOGIN)
    @PostMapping(path = "saveUserRelation")
    public ResVo<Boolean> saveUserRelation(@RequestBody UserRelationReq req) {
        userRelationService.saveUserRelation(req);
        return ResVo.ok(true);
    }

    /**
     * 保存用户详情
     *
     * @param req
     * @return
     * @throws Exception
     */
    @Permission(role = UserRole.LOGIN)
    @PostMapping(path = "saveUserInfo")
    @Transactional(rollbackFor = Exception.class)
    public ResVo<Boolean> saveUserInfo(@RequestBody UserInfoSaveReq req) {
        if (req.getUserId() == null || !Objects.equals(req.getUserId(), ReqInfoContext.getReqInfo().getUserId())) {
            // 不能修改其他用户的信息
            return ResVo.fail(StatusEnum.FORBID_ERROR_MIXED, "无权修改");
        }
        userService.saveUserInfo(req);
        return ResVo.ok(true);
    }

    /**
     * 用户的文章列表翻页
     *
     * @param userId
     * @param homeSelectType
     * @return
     */
    @GetMapping(path = "articleList")
    public ResVo<NextPageHtmlVo> articleList(@RequestParam(name = "userId") Long userId,
                                             @RequestParam(name = "homeSelectType") String homeSelectType,
                                             @RequestParam("page") Long page,
                                             @RequestParam(name = "pageSize", required = false) Long pageSize) {
        HomeSelectEnum select = HomeSelectEnum.fromCode(homeSelectType);
        if (select == null) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS);
        }

        if (pageSize == null) pageSize = PageParam.DEFAULT_PAGE_SIZE;
        PageParam pageParam = PageParam.newPageInstance(page, pageSize);
        PageListVo<ArticleDTO> dto = articleReadService.queryArticlesByUserAndType(userId, pageParam, select);
        String html = templateEngineHelper.renderToVo("views/user/articles/index", "homeSelectList", dto);
        return ResVo.ok(new NextPageHtmlVo(html, dto.getHasMore()));
    }

    @GetMapping(path = "followList")
    public ResVo<NextPageHtmlVo> followList(@RequestParam(name = "userId") Long userId,
                                            @RequestParam(name = "followSelectType") String followSelectType,
                                            @RequestParam("page") Long page,
                                            @RequestParam(name = "pageSize", required = false) Long pageSize) {
        if (pageSize == null) pageSize = PageParam.DEFAULT_PAGE_SIZE;
        PageParam pageParam = PageParam.newPageInstance(page, pageSize);
        PageListVo<FollowUserInfoDTO> followList;
        boolean needUpdateRelation = false;
        if (followSelectType.equals(FollowTypeEnum.FOLLOW.getCode())) {
            followList = userRelationService.getUserFollowList(userId, pageParam);
        } else {
            // 查询粉丝列表时，只能确定粉丝关注了userId，但是不能反向判断，因此需要再更新下映射关系，判断userId是否有关注这个用户
            followList = userRelationService.getUserFansList(userId, pageParam);
            needUpdateRelation = true;
        }

        Long loginUserId = ReqInfoContext.getReqInfo().getUserId();
        if (!Objects.equals(loginUserId, userId) || needUpdateRelation) {
            userRelationService.updateUserFollowRelationId(followList, userId);
        }
        String html = templateEngineHelper.renderToVo("views/user/follows/index", "followList", followList);
        return ResVo.ok(new NextPageHtmlVo(html, followList.getHasMore()));
    }
}
