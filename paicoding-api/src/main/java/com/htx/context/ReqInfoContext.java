package com.htx.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.htx.vo.seo.Seo;
import com.htx.vo.user.dto.BaseUserInfoDTO;
import lombok.Data;

import java.security.Principal;

/**
 * 微信搜索「二哈学习之路」
 * 请求上下文，携带用户身份相关信息
 * @author htx
 * @date 2024/8/20 22:14
 */
public class ReqInfoContext {
    private static TransmittableThreadLocal<ReqInfo> contexts = new TransmittableThreadLocal<>();

    public static void addReqInfo(ReqInfo reqInfo) {
        contexts.set(reqInfo);
    }

    public static void clear() {
        contexts.remove();
    }

    public static ReqInfo getReqInfo() {
        return contexts.get();
    }

    @Data
    public static class ReqInfo implements Principal {
        /**
         * appKey
         */
        private String appKey;
        /**
         * 访问的域名
         */
        private String host;
        /**
         * 访问路径
         */
        private String path;
        /**
         * 客户端ip
         */
        private String clientIp;
        /**
         * referer
         */
        private String referer;
        /**
         * post 表单参数
         */
        private String payload;
        /**
         * 设备信息
         */
        private String userAgent;

        /**
         * 登录的会话
         */
        private String session;

        /**
         * 用户id
         */
        private Long userId;
        /**
         * 用户信息
         */
        private BaseUserInfoDTO user;
        /**
         * 消息数量
         */
        private Integer msgNum;

        private Seo seo;

        private String deviceId;

        @Override
        public String getName() {
            return session;
        }
    }
}
