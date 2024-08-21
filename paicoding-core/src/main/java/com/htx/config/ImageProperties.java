package com.htx.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信搜索「二哈学习之路」
 * 图片配置文件
 * @author htx
 * @date 2024/8/21 20:56
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "image")
public class ImageProperties {

    /**
     * 存储绝对路径
     */
    private String absTmpPath;

    /**
     * 存储相对路径
     */
    private String webImgPath;

    /**
     * 上传文件的临时存储目录
     */
    private String tmpUploadPath;

    /**
     * 访问图片的host
     */
    private String cdnHost;

    private OssProperties oss;

    public String buildImgUrl(String url) {
        if (!url.startsWith(cdnHost)) {
            return cdnHost + url;
        }
        return url;
    }
}
