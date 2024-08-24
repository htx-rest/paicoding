package com.htx.notify.config;

import com.htx.async.AsyncUtil;
import com.htx.config.RabbitmqProperties;
import com.htx.rabbitmq.RabbitmqConnectionPool;
import com.htx.notify.service.RabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * 微信搜索「二哈学习之路」
 *
 * @author htx
 * @date 2024/8/24 21:03
 */
@Configuration
@ConditionalOnProperty(value = "rabbitmq.switchFlag")
@EnableConfigurationProperties(RabbitmqProperties.class)
public class RabbitMqAutoConfig implements ApplicationRunner {
    @Resource
    private RabbitmqService rabbitmqService;

    @Autowired
    private RabbitmqProperties rabbitmqProperties;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String host = rabbitmqProperties.getHost();
        Integer port = rabbitmqProperties.getPort();
        String userName = rabbitmqProperties.getUsername();
        String password = rabbitmqProperties.getPassport();
        String virtualhost = rabbitmqProperties.getVirtualhost();
        Integer poolSize = rabbitmqProperties.getPoolSize();
        RabbitmqConnectionPool.initRabbitmqConnectionPool(host, port, userName, password, virtualhost, poolSize);
        AsyncUtil.execute(() -> rabbitmqService.processConsumerMsg());
    }
}
