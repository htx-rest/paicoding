package com.htx.front.chat.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 23:16
 */
@Controller
@RequestMapping(path = "chat")
public class ChatViewController {
    @RequestMapping(path = {"", "/", "home"})
    public String index() {
        return "views/chat-home/index";
    }
}
