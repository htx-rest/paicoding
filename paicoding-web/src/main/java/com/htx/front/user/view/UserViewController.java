package com.htx.front.user.view;

import com.htx.context.ReqInfoContext;
import com.htx.enums.FollowSelectEnum;
import com.htx.enums.FollowTypeEnum;
import com.htx.enums.HomeSelectEnum;
import com.htx.vo.PageListVo;
import com.htx.vo.PageParam;
import com.htx.vo.article.dto.ArticleDTO;
import com.htx.vo.article.dto.TagSelectDTO;
import com.htx.vo.user.dto.FollowUserInfoDTO;
import com.htx.vo.user.dto.UserStatisticInfoDTO;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.util.SpringUtil;
import com.htx.article.service.ArticleReadService;
import com.htx.user.service.UserRelationService;
import com.htx.user.service.UserService;
import com.htx.front.user.vo.UserHomeVo;
import com.htx.global.BaseViewController;
import com.htx.global.SeoInjectService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 微信搜索「二哈学习之路」
 * 用户注册、取消，登录、登出
 * @author htx
 * @date 2024/8/24 22:50
 */
@Controller
@RequestMapping(path = "user")
@Slf4j
public class UserViewController extends BaseViewController {

    @Resource
    private UserService userService;

    @Resource
    private UserRelationService userRelationService;

    @Resource
    private ArticleReadService articleReadService;

    private static final List<String> homeSelectTags = Arrays.asList("article", "read", "follow", "collection");
    private static final List<String> followSelectTags = Arrays.asList("follow", "fans");

    /**
     * 获取用户主页信息，通常只有作者本人才能进入这个页面
     *
     * @return
     */
    @Permission(role = UserRole.LOGIN)
    @GetMapping(path = "home")
    public String getUserHome(@RequestParam(name = "userId") Long userId,
                              @RequestParam(name = "homeSelectType", required = false) String homeSelectType,
                              @RequestParam(name = "followSelectType", required = false) String followSelectType,
                              Model model) {
        UserHomeVo vo = new UserHomeVo();
        vo.setHomeSelectType(StringUtils.isBlank(homeSelectType) ? HomeSelectEnum.ARTICLE.getCode() : homeSelectType);
        vo.setFollowSelectType(StringUtils.isBlank(followSelectType) ? FollowTypeEnum.FOLLOW.getCode() : followSelectType);

        UserStatisticInfoDTO userInfo = userService.queryUserInfoWithStatistic(userId);
        vo.setUserHome(userInfo);

        List<TagSelectDTO> homeSelectTags = homeSelectTags(vo.getHomeSelectType(), Objects.equals(userId, ReqInfoContext.getReqInfo().getUserId()));
        vo.setHomeSelectTags(homeSelectTags);

        userHomeSelectList(vo, userId);
        model.addAttribute("vo", vo);
        SpringUtil.getBean(SeoInjectService.class).initUserSeo(vo);
        return "views/user/index";
    }

    /**
     * 访问其他用户的主页
     *
     * @param userId
     * @param homeSelectType
     * @param followSelectType
     * @param model
     * @return
     */
    @GetMapping(path = "/{userId}")
    public String detail(@PathVariable(name = "userId") Long userId, @RequestParam(name = "homeSelectType", required = false) String homeSelectType,
                         @RequestParam(name = "followSelectType", required = false) String followSelectType,
                         Model model) {
        UserHomeVo vo = new UserHomeVo();
        vo.setHomeSelectType(StringUtils.isBlank(homeSelectType) ? HomeSelectEnum.ARTICLE.getCode() : homeSelectType);
        vo.setFollowSelectType(StringUtils.isBlank(followSelectType) ? FollowTypeEnum.FOLLOW.getCode() : followSelectType);

        UserStatisticInfoDTO userInfo = userService.queryUserInfoWithStatistic(userId);
        vo.setUserHome(userInfo);

        List<TagSelectDTO> homeSelectTags = homeSelectTags(vo.getHomeSelectType(), Objects.equals(userId, ReqInfoContext.getReqInfo().getUserId()));
        vo.setHomeSelectTags(homeSelectTags);

        userHomeSelectList(vo, userId);
        model.addAttribute("vo", vo);
        SpringUtil.getBean(SeoInjectService.class).initUserSeo(vo);
        return "views/user/index";
    }

    /**
     * 返回Home页选择列表标签
     *
     * @param selectType
     * @param isAuthor true 表示当前为查看自己的个人主页
     * @return
     */
    private List<TagSelectDTO> homeSelectTags(String selectType, boolean isAuthor) {
        List<TagSelectDTO> tags = new ArrayList<>();
        homeSelectTags.forEach(tag -> {
            if (!isAuthor && "read".equals(tag)) {
                // 只有本人才能看自己的阅读历史
                return;
            }
            TagSelectDTO tagSelectDTO = new TagSelectDTO();
            tagSelectDTO.setSelectType(tag);
            tagSelectDTO.setSelectDesc(HomeSelectEnum.fromCode(tag).getDesc());
            tagSelectDTO.setSelected(selectType.equals(tag));
            tags.add(tagSelectDTO);
        });
        return tags;
    }

    /**
     * 返回关注用户选择列表标签
     *
     * @param selectType
     * @return
     */
    private List<TagSelectDTO> followSelectTags(String selectType) {
        List<TagSelectDTO> tags = new ArrayList<>();
        followSelectTags.forEach(tag -> {
            TagSelectDTO tagSelectDTO = new TagSelectDTO();
            tagSelectDTO.setSelectType(tag);
            tagSelectDTO.setSelectDesc(FollowSelectEnum.fromCode(tag).getDesc());
            tagSelectDTO.setSelected(selectType.equals(tag));
            tags.add(tagSelectDTO);
        });
        return tags;
    }

    /**
     * 返回选择列表
     *
     * @param vo
     * @param userId
     */
    private void userHomeSelectList(UserHomeVo vo, Long userId) {
        PageParam pageParam = PageParam.newPageInstance();
        HomeSelectEnum select = HomeSelectEnum.fromCode(vo.getHomeSelectType());
        if (select == null) {
            return;
        }

        switch (select) {
            case ARTICLE:
            case READ:
            case COLLECTION:
                PageListVo<ArticleDTO> dto = articleReadService.queryArticlesByUserAndType(userId, pageParam, select);
                vo.setHomeSelectList(dto);
                return;
            case FOLLOW:
                // 关注用户与被关注用户
                // 获取选择标签
                List<TagSelectDTO> followSelectTags = followSelectTags(vo.getFollowSelectType());
                vo.setFollowSelectTags(followSelectTags);
                initFollowFansList(vo, userId, pageParam);
                return;
            default:
        }
    }

    private void initFollowFansList(UserHomeVo vo, long userId, PageParam pageParam) {
        PageListVo<FollowUserInfoDTO> followList;
        boolean needUpdateRelation = false;
        if (vo.getFollowSelectType().equals(FollowTypeEnum.FOLLOW.getCode())) {
            followList = userRelationService.getUserFollowList(userId, pageParam);
        } else {
            // 查询粉丝列表时，只能确定粉丝关注了userId，但是不能反向判断，因此需要再更新下映射关系，判断userId是否有关注这个用户
            followList = userRelationService.getUserFansList(userId, pageParam);
            needUpdateRelation = true;
        }

        Long loginUserId = ReqInfoContext.getReqInfo().getUserId();
        if (!Objects.equals(loginUserId, userId) || needUpdateRelation) {
            userRelationService.updateUserFollowRelationId(followList, loginUserId);
        }
        vo.setFollowList(followList);
    }
}
