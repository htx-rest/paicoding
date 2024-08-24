package com.htx.front.login.wx.controller;

import com.htx.vo.ResVo;
import com.htx.mdc.MdcDot;
import com.htx.front.login.wx.helper.WxLoginHelper;
import com.htx.front.login.wx.vo.WxLoginVo;
import com.htx.global.BaseViewController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 微信搜索「二哈学习之路」
 * 公众号登陆的长连接控制器
 * @author htx
 * @date 2024/8/24 23:01
 */
@Controller
@Slf4j
public class WxLoginController extends BaseViewController {
    @Autowired
    private WxLoginHelper qrLoginHelper;

    /**
     * 客户端与后端建立扫描二维码的长连接
     *
     * @return
     */
    @MdcDot
    @ResponseBody
    @GetMapping(path = "subscribe", produces = {org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE})
    public SseEmitter subscribe(String deviceId) throws IOException {
        return qrLoginHelper.subscribe();
    }

    @GetMapping(path = "/login/fetch")
    @ResponseBody
    public String resendCode(String deviceId) throws IOException {
        return qrLoginHelper.resend();
    }

    /**
     * 刷新验证码
     *
     * @return
     * @throws IOException
     */
    @MdcDot
    @GetMapping(path = "/login/refresh")
    @ResponseBody
    public ResVo<WxLoginVo> refresh(String deviceId) throws IOException {
        WxLoginVo vo = new WxLoginVo();
        String code = qrLoginHelper.refreshCode();
        if (StringUtils.isBlank(code)) {
            // 刷新失败，之前的连接已失效，重新建立连接
            vo.setCode(code);
            vo.setReconnect(true);
        } else {
            vo.setCode(code);
            vo.setReconnect(false);
        }
        return ResVo.ok(vo);
    }
}
