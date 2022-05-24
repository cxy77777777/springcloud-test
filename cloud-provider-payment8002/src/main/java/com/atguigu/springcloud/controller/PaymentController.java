package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api")
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/getData")
    public CommonResult<Payment> getData(){
        log.info("获取数据");
        return  new CommonResult(200,"success8002",paymentService.getPaymentById(1l));
    }
}
