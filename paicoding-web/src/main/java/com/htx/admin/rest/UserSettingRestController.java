package com.htx.admin.rest;

import com.htx.context.ReqInfoContext;
import com.htx.vo.ResVo;
import com.htx.vo.user.dto.BaseUserInfoDTO;
import com.htx.vo.user.dto.SimpleUserInfoDTO;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.user.service.UserService;
import com.htx.front.search.vo.SearchUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 * 用户权限管理后台
 * @author htx
 * @date 2024/8/24 22:24
 */
@RestController
@Permission(role = UserRole.ADMIN)
@Api(value = "用户管理控制器", tags = "用户管理")
@RequestMapping(path = {"api/admin/user/", "admin/user/"})
public class UserSettingRestController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户搜索")
    @GetMapping(path = "query")
    public ResVo<SearchUserVo> queryUserList(@RequestParam(name = "key", required = false) String key) {
        List<SimpleUserInfoDTO> list = userService.searchUser(key);
        SearchUserVo vo = new SearchUserVo();
        vo.setKey(key);
        vo.setItems(list);
        return ResVo.ok(vo);
    }

    @Permission(role = UserRole.LOGIN)
    @ApiOperation("获取当前登录用户信息")
    @GetMapping("info")
    public ResVo<BaseUserInfoDTO> info() {
        BaseUserInfoDTO user = ReqInfoContext.getReqInfo().getUser();
        return ResVo.ok(user);
    }
}
