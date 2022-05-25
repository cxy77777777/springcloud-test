package com.atguigu.springcloud.service;

import entities.CommonResult;
import entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentService {

    @GetMapping("/api/getData")
    CommonResult<Payment> getData();

    @GetMapping("/api/payment/feign")
    public CommonResult<Payment> getFeign();
}
