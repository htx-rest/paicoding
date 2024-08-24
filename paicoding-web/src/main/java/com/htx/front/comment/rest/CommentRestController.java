package com.htx.front.comment.rest;

import com.htx.context.ReqInfoContext;
import com.htx.enums.DocumentTypeEnum;
import com.htx.enums.NotifyTypeEnum;
import com.htx.enums.OperateTypeEnum;
import com.htx.vo.PageParam;
import com.htx.vo.ResVo;
import com.htx.vo.comment.CommentSaveReq;
import com.htx.vo.comment.dto.TopCommentDTO;
import com.htx.vo.constants.StatusEnum;
import com.htx.vo.notify.NotifyMsgEvent;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.util.NumUtil;
import com.htx.util.SpringUtil;
import com.htx.article.conveter.ArticleConverter;
import com.htx.article.repository.entity.ArticleDO;
import com.htx.article.service.ArticleReadService;
import com.htx.comment.repository.entity.CommentDO;
import com.htx.comment.service.CommentReadService;
import com.htx.comment.service.CommentWriteService;
import com.htx.user.repository.entity.UserFootDO;
import com.htx.user.service.UserFootService;
import com.htx.component.TemplateEngineHelper;
import com.htx.front.article.vo.ArticleDetailVo;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 微信搜索「二哈学习之路」
 * 评论
 * @author htx
 * @date 2024/8/24 23:03
 */
@RestController
@RequestMapping(path = "comment/api")
public class CommentRestController {
    @Autowired
    private ArticleReadService articleReadService;

    @Autowired
    private CommentReadService commentReadService;

    @Autowired
    private CommentWriteService commentWriteService;

    @Autowired
    private UserFootService userFootService;

    @Autowired
    private TemplateEngineHelper templateEngineHelper;

    /**
     * 评论列表页
     *
     * @param articleId
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "list")
    public ResVo<List<TopCommentDTO>> list(Long articleId, Long pageNum, Long pageSize) {
        if (NumUtil.nullOrZero(articleId)) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, "文章id为空");
        }
        pageNum = Optional.ofNullable(pageNum).orElse(PageParam.DEFAULT_PAGE_NUM);
        pageSize = Optional.ofNullable(pageSize).orElse(PageParam.DEFAULT_PAGE_SIZE);
        List<TopCommentDTO> result = commentReadService.getArticleComments(articleId, PageParam.newPageInstance(pageNum, pageSize));
        return ResVo.ok(result);
    }

    /**
     * 保存评论
     *
     * @param req
     * @return
     */
    @Permission(role = UserRole.LOGIN)
    @PostMapping(path = "post")
    @ResponseBody
    public ResVo<String> save(@RequestBody CommentSaveReq req) {
        if (req.getArticleId() == null) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, "文章id为空");
        }
        ArticleDO article = articleReadService.queryBasicArticle(req.getArticleId());
        if (article == null) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, "文章不存在!");
        }

        // 保存评论
        req.setUserId(ReqInfoContext.getReqInfo().getUserId());
        req.setCommentContent(StringEscapeUtils.escapeHtml3(req.getCommentContent()));
        commentWriteService.saveComment(req);

        // 返回新的评论信息，用于实时更新详情也的评论列表
        ArticleDetailVo vo = new ArticleDetailVo();
        vo.setArticle(ArticleConverter.toDto(article));
        // 评论信息
        List<TopCommentDTO> comments = commentReadService.getArticleComments(req.getArticleId(), PageParam.newPageInstance());
        vo.setComments(comments);

        // 热门评论
        TopCommentDTO hotComment = commentReadService.queryHotComment(req.getArticleId());
        vo.setHotComment(hotComment);
        String content = templateEngineHelper.render("views/article-detail/comment/index", vo);
        return ResVo.ok(content);
    }

    /**
     * 删除评论
     *
     * @param commentId
     * @return
     */
    @Permission(role = UserRole.LOGIN)
    @RequestMapping(path = "delete")
    public ResVo<Boolean> delete(Long commentId) {
        commentWriteService.deleteComment(commentId, ReqInfoContext.getReqInfo().getUserId());
        return ResVo.ok(true);
    }

    /**
     * 收藏、点赞等相关操作
     *
     * @param commendId
     * @param type      取值来自于 OperateTypeEnum#code
     * @return
     */
    @Permission(role = UserRole.LOGIN)
    @GetMapping(path = "favor")
    public ResVo<Boolean> favor(@RequestParam(name = "commentId") Long commendId,
                                @RequestParam(name = "type") Integer type) {
        OperateTypeEnum operate = OperateTypeEnum.fromCode(type);
        if (operate == OperateTypeEnum.EMPTY) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, type + "非法");
        }

        // 要求文章必须存在
        CommentDO comment = commentReadService.queryComment(commendId);
        if (comment == null) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS_MIXED, "评论不存在!");
        }

        UserFootDO foot = userFootService.saveOrUpdateUserFoot(DocumentTypeEnum.COMMENT,
                commendId,
                comment.getUserId(),
                ReqInfoContext.getReqInfo().getUserId(),
                operate);
        // 点赞、收藏消息
        NotifyTypeEnum notifyType = OperateTypeEnum.getNotifyType(operate);
        Optional.ofNullable(notifyType).ifPresent(notify -> SpringUtil.publishEvent(new NotifyMsgEvent<>(this, notify, foot)));
        return ResVo.ok(true);
    }

}
