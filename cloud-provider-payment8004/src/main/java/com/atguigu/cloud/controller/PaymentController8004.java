package com.atguigu.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("paymentzk/")
@Slf4j
public class PaymentController8004 {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("paymentzk")
    public String paymentzk(){
        return "springCloud-with-zookeeper:" + serverPort + "," + UUID.randomUUID().toString();
    }
}
