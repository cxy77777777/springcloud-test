package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Orderzk9003 {
    public static void main(String[] args) {
        SpringApplication.run(Orderzk9003.class,args);
    }
}
