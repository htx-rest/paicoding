package com.htx.vo.seo;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 23:03
 */
@Data
@Builder
public class Seo {
    private List<SeoTagVo> ogp;
    private Map<String, Object> jsonLd;
}
