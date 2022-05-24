package com.atguigu.springcloud.controller;

import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RequestMapping("consumer/order")
@RestController
@Slf4j
public class PaymentController {

//    private static final String HTTPHOST = "http://localhost:8001/";
    private static final String HTTPHOST = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/getData")
    public CommonResult<Payment> getData(){
        log.info("获取数据");
        return  new CommonResult(200,"success",restTemplate.getForObject(HTTPHOST + "/api/getData",CommonResult.class));
    }
}
