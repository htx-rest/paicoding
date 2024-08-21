package com.htx.admin.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 21:25
 */
@RestController
@Api(value = "后台登录登出管理控制器", tags = "后台登录")
@RequestMapping(path = {"/api/admin", "/admin"})
public class AdminLoginController {
}
