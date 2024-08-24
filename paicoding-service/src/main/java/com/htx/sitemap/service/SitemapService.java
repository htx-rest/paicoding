package com.htx.sitemap.service;

import com.htx.sitemap.model.SiteCntVo;
import com.htx.sitemap.model.SiteMapVo;

import java.time.LocalDate;

/**
 * 微信搜索「二哈学习之路」
 * 站点统计相关服务：
 * - 站点地图
 * - pv/uv
 * @author htx
 * @date 2024/8/24 20:57
 */
public interface SitemapService {

    /**
     * 查询站点地图
     *
     * @return
     */
    SiteMapVo getSiteMap();

    /**
     * 刷新站点地图
     */
    void refreshSitemap();

    /**
     * 保存用户访问信息
     *
     * @param visitIp 访问者ip
     * @param path    访问的资源路径
     */
    void saveVisitInfo(String visitIp, String path);


    /**
     * 查询站点某一天or总的访问信息
     *
     * @param date 日期，为空时，表示查询所有的站点信息
     * @param path 访问路径，为空时表示查站点信息
     * @return
     */
    SiteCntVo querySiteVisitInfo(LocalDate date, String path);
}
