package com.htx.admin.rest;

import com.htx.enums.PushStatusEnum;
import com.htx.vo.PageVo;
import com.htx.vo.ResVo;
import com.htx.vo.article.CategoryReq;
import com.htx.vo.article.SearchCategoryReq;
import com.htx.vo.article.dto.CategoryDTO;
import com.htx.vo.constants.StatusEnum;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.article.service.CategorySettingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 微信搜索「二哈学习之路」
 * 分类后台
 * @author htx
 * @date 2024/8/24 22:18
 */
@RestController
@Permission(role = UserRole.LOGIN)
@Api(value = "文章类目管理控制器", tags = "类目管理")
@RequestMapping(path = {"api/admin/category/", "admin/category/"})
public class CategorySettingRestController {

    @Autowired
    private CategorySettingService categorySettingService;


    @Permission(role = UserRole.ADMIN)
    @PostMapping(path = "save")
    public ResVo<String> save(@RequestBody CategoryReq req) {
        categorySettingService.saveCategory(req);
        return ResVo.ok();
    }


    @Permission(role = UserRole.ADMIN)
    @GetMapping(path = "delete")
    public ResVo<String> delete(@RequestParam(name = "categoryId") Integer categoryId) {
        categorySettingService.deleteCategory(categoryId);
        return ResVo.ok();
    }


    @Permission(role = UserRole.ADMIN)
    @GetMapping(path = "operate")
    public ResVo<String> operate(@RequestParam(name = "categoryId") Integer categoryId,
                                 @RequestParam(name = "pushStatus") Integer pushStatus) {
        if (pushStatus != PushStatusEnum.OFFLINE.getCode() && pushStatus!= PushStatusEnum.ONLINE.getCode()) {
            return ResVo.fail(StatusEnum.ILLEGAL_ARGUMENTS);
        }
        categorySettingService.operateCategory(categoryId, pushStatus);
        return ResVo.ok();
    }


    @PostMapping(path = "list")
    public ResVo<PageVo<CategoryDTO>> list(@RequestBody SearchCategoryReq req) {
        PageVo<CategoryDTO> categoryDTOPageVo = categorySettingService.getCategoryList(req);
        return ResVo.ok(categoryDTOPageVo);
    }
}
