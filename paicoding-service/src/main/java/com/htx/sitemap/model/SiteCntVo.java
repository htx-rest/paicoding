package com.htx.sitemap.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信搜索「二哈学习之路」
 * 站点计数
 * @author htx
 * @date 2024/8/24 20:55
 */
@Data
public class SiteCntVo implements Serializable {
    private static final long serialVersionUID = 8747459624770066661L;
    /**
     * 日期
     */
    private String day;
    /**
     * 路径，全站时，path为null
     */
    private String path;
    /**
     * 站点page view 点击数
     */
    private Integer pv;
    /**
     * 站点unique view 点击数
     */
    private Integer uv;
}
