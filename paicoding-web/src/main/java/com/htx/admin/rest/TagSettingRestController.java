package com.htx.admin.rest;

import com.htx.enums.PushStatusEnum;
import com.htx.vo.PageVo;
import com.htx.vo.ResVo;
import com.htx.vo.article.SearchTagReq;
import com.htx.vo.article.TagReq;
import com.htx.vo.article.dto.TagDTO;
import com.htx.vo.constants.StatusEnum;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.article.service.TagSettingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 微信搜索「二哈学习之路」
 * 标签后台
 * @author htx
 * @date 2024/8/24 22:23
 */
@RestController
@Permission(role = UserRole.LOGIN)
@Api(value = "文章标签管理控制器", tags = "标签管理")
@RequestMapping(path = {"api/admin/tag/", "admin/tag/"})
public class TagSettingRestController {

    @Autowired
    private TagSettingService tagSettingService;

    @Permission(role = UserRole.ADMIN)
    @PostMapping(path = "save")
    public ResVo<String> save(@RequestBody TagReq req) {
        tagSettingService.saveTag(req);
        return ResVo.ok();
    }

    @Permission(role = UserRole.ADMIN)
    @GetMapping(path = "delete")
    public ResVo<String> delete(@RequestParam(name = "tagId") Integer tagId) {
        tagSettingService.deleteTag(tagId);
        return ResVo.ok();
    }

    @Permission(role = UserRole.ADMIN)
    @GetMapping(path = "operate")
    public ResVo<String> operate(@RequestParam(name = "tagId") Integer tagId,
                                 @RequestParam(name = "pushStatus") Integer pushStatus) {
        if (pushStatus != PushStatusEnum.OFFLINE.getCode() && pushStatus != PushStatusEnum.ONLINE.getCode()) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS);
        }
        tagSettingService.operateTag(tagId, pushStatus);
        return ResVo.ok();
    }

    @PostMapping(path = "list")
    public ResVo<PageVo<TagDTO>> list(@RequestBody SearchTagReq req) {
        PageVo<TagDTO> tagDTOPageVo = tagSettingService.getTagList(req);
        return ResVo.ok(tagDTOPageVo);
    }
}
