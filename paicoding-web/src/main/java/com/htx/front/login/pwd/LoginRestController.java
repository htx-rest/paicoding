package com.htx.front.login.pwd;

import com.htx.context.ReqInfoContext;
import com.htx.vo.ResVo;
import com.htx.vo.constants.StatusEnum;
import com.htx.vo.user.UserPwdLoginReq;
import com.htx.permission.Permission;
import com.htx.permission.UserRole;
import com.htx.util.SessionUtil;
import com.htx.user.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * 微信搜索「二哈学习之路」
 * 用户名 密码方式的登录/登出的入口
 * @author htx
 * @date 2024/8/24 22:57
 */
@RestController
@RequestMapping
public class LoginRestController {
    @Autowired
    private LoginService loginService;

    /**
     * 用户名和密码登录
     * 可以根据星球编号/用户名进行密码匹配
     */
    @PostMapping("/login/username")
    public ResVo<Boolean> login(@RequestParam(name = "username") String username,
                                @RequestParam(name = "password") String password,
                                HttpServletResponse response) {
        String session = loginService.loginByUserPwd(username, password);
        if (StringUtils.isNotBlank(session)) {
            // cookie中写入用户登录信息，用于身份识别
            response.addCookie(SessionUtil.newCookie(LoginService.SESSION_KEY, session));
            return ResVo.ok(true);
        } else {
            return ResVo.fail(StatusEnum.LOGIN_FAILED_MIXED, "用户名和密码登录异常，请稍后重试");
        }
    }

    /**
     * 绑定星球账号
     */
    @PostMapping("/login/register")
    public ResVo<Boolean> register(UserPwdLoginReq loginReq,
                                   HttpServletResponse response) {
        String session = loginService.registerByUserPwd(loginReq);
        if (StringUtils.isNotBlank(session)) {
            // cookie中写入用户登录信息，用于身份识别
            response.addCookie(SessionUtil.newCookie(LoginService.SESSION_KEY, session));
            return ResVo.ok(true);
        } else {
            return ResVo.fail(StatusEnum.LOGIN_FAILED_MIXED, "用户名和密码登录异常，请稍后重试");
        }
    }

    @Permission(role = UserRole.LOGIN)
    @RequestMapping("logout")
    public ResVo<Boolean> logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 释放会话
        request.getSession().invalidate();
        Optional.ofNullable(ReqInfoContext.getReqInfo()).ifPresent(s -> loginService.logout(s.getSession()));
        // 移除cookie
        response.addCookie(SessionUtil.delCookie(LoginService.SESSION_KEY));
        // 重定向到当前页面
        String referer = request.getHeader("Referer");
        if (StringUtils.isBlank(referer)) {
            referer = "/";
        }
        response.sendRedirect(referer);
        return ResVo.ok(true);
    }
}
