package com.htx;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/20 20:59
 */
@Slf4j
@EnableAsync
@EnableScheduling
@ServletComponentScan
@SpringBootApplication
public class QuickPaicodingApplication implements WebMvcConfigurer, ApplicationRunner {
    @Override
    public void run(ApplicationArguments args){
        // 设置类型转换, 主要用于mybatis读取varchar/json类型数据据，并写入到json格式的实体Entity中
        JacksonTypeHandler.setObjectMapper(new ObjectMapper());
        // 应用启动之后执行

    }
}
