package com.htx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 21:47
 */
@Configuration
@ComponentScan(basePackages = "com.htx")
@MapperScan(basePackages = {
        "com.htx.article.repository.mapper",
        "com.htx.user.repository.mapper",
        "com.htx.comment.repository.mapper",
        "com.htx.config.repository.mapper",
        "com.htx.statistics.repository.mapper",
        "com.htx.notify.repository.mapper",})
public class ServiceAutoConfig {
}
