package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("consul/")
public class PaymentConsulController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("paymentconsul")
    public String paymentconsul(){
        return "springCloud-with-consul:" + serverPort + "," + UUID.randomUUID().toString();
    }
}
