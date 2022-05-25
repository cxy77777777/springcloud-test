package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志增强
 * 1.配置bean
 * 2.配置yml文件
 * logging:
 *   level:
 *     com.atguigu.springcloud.service.PaymentService: debug #feign日志以什么级别，监控那个接口
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
