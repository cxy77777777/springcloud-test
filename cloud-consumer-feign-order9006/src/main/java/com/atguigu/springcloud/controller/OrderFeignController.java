package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * OpenFeign调用
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("getFeignData")
    public CommonResult<Payment> getFeignData(){
        return paymentService.getData();
    }

    @GetMapping("consumer/feign")
    public CommonResult<Payment> getFeign(){
        return paymentService.getFeign();
    }
}
