package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempleatConfig {

    @Bean
//    @LoadBalanced //远程调用服务方式三：Ribbon负载均衡器注解（手写负载均衡算法，需把这行注释掉）
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
