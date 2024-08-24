package com.htx.sitemap.constants;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 微信搜索「二哈学习之路」
 * 站点相关地图
 * @author htx
 * @date 2024/8/24 20:54
 */
public class SitemapConstants {
    public static final String SITE_VISIT_KEY = "visit_info";

    public static String day(LocalDate day) {
        return DateTimeFormatter.ofPattern("yyyyMMdd").format(day);
    }
}

