package com.htx.admin.rest;

import com.htx.context.ReqInfoContext;
import com.htx.vo.ResVo;
import com.htx.vo.constants.StatusEnum;
import com.htx.vo.user.dto.BaseUserInfoDTO;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.util.SessionUtil;
import com.htx.user.service.AuthorWhiteListService;
import com.htx.user.service.LoginService;
import com.htx.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * 微信搜索「二哈学习之路」
 * 文章后台
 * @author htx
 * @date 2024/8/20 21:25
 */
@RestController
@Api(value = "后台登录登出管理控制器", tags = "后台登录")
@RequestMapping(path = {"/api/admin", "/admin"})
public class AdminLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginOutService;

    @Autowired
    private AuthorWhiteListService articleWhiteListService;

    /**
     * 后台用户名 & 密码的方式登录
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(path = {"login"})
    public ResVo<BaseUserInfoDTO> login(HttpServletRequest request,
                                        HttpServletResponse response) {
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
        String session = loginOutService.loginByUserPwd(username, pwd);
        if (StringUtils.isNotBlank(session)) {
            // cookie中写入用户登录信息
            response.addCookie(SessionUtil.newCookie(LoginService.SESSION_KEY, session));
            return ResVo.ok(userService.queryBasicUserInfo(ReqInfoContext.getReqInfo().getUserId()));
        } else {
            return ResVo.fail(StatusEnum.LOGIN_FAILED_MIXED, "登录失败，请重试");
        }
    }

    /**
     * 判断是否有登录
     *
     * @return
     */
    @RequestMapping(path = "isLogined")
    public ResVo<Boolean> isLogined() {
        return ResVo.ok(ReqInfoContext.getReqInfo().getUserId() != null);
    }

    @ApiOperation("获取当前登录用户信息")
    @GetMapping("info")
    public ResVo<BaseUserInfoDTO> info() {
        BaseUserInfoDTO user = ReqInfoContext.getReqInfo().getUser();
        return ResVo.ok(user);
    }

    /**
     * 登出
     *
     * @param response
     * @return
     */
    @Permission(role = UserRole.LOGIN)
    @GetMapping("logout")
    public ResVo<Boolean> logOut(HttpServletResponse response) {
        Optional.ofNullable(ReqInfoContext.getReqInfo()).ifPresent(s -> loginOutService.logout(s.getSession()));
        // 为什么不后端实现重定向？ 重定向交给前端执行，避免由于前后端分离，本地开发时端口不一致导致的问题
        // response.sendRedirect("/");

        // 移除cookie
        response.addCookie(SessionUtil.delCookie(LoginService.SESSION_KEY));
        return ResVo.ok(true);
    }
}
