package com.htx.global.vo;

import com.htx.vo.seo.SeoTagVo;
import com.htx.vo.user.dto.BaseUserInfoDTO;
import com.htx.sitemap.model.SiteCntVo;
import com.htx.config.GlobalViewConfig;
import lombok.Data;

import java.util.List;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 21:56
 */
@Data
public class GlobalVo {
    /**
     * 网站相关配置
     */
    private GlobalViewConfig siteInfo;
    /**
     * 站点统计信息
     */
    private SiteCntVo siteStatisticInfo;

    /**
     * 今日的站点统计想你洗
     */
    private SiteCntVo todaySiteStatisticInfo;

    /**
     * 环境
     */
    private String env;

    /**
     * 是否已登录
     */
    private Boolean isLogin;

    /**
     * 登录用户信息
     */
    private BaseUserInfoDTO user;

    /**
     * 消息通知数量
     */
    private Integer msgNum;

    /**
     * 在线用户人数
     */
    private Integer onlineCnt;

    private String currentDomain;

    private List<SeoTagVo> ogp;
    private String jsonLd;

}
