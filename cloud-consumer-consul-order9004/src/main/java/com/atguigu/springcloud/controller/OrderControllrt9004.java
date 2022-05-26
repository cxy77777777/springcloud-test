package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * consul.。
 */
@RestController
@RequestMapping("consul/")
@Slf4j
public class OrderControllrt9004 {
    private static final String INSTANCE_HOST = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("getPayment8006")
    public String getPayment8006(){
        return restTemplate.getForObject(INSTANCE_HOST + "/consul/paymentconsul",String.class);
    }
}
