//package com.atguigu.myrule;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 自定义负载均衡,新版springcloud 不支持
// */
//@Configuration
//public class MySelfRule {
//
//    @Bean
//    public IRule mySelfRul(){
//        return new RandomRule();//定义为随机
//    }
//}
