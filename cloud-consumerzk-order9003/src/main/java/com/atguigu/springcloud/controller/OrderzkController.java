package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("orderzk/")
public class OrderzkController {
    private static final String INVOKE_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("getInvokeUrl")
    public String getInvokeUrl(){
        StringUtils.isNotEmpty("sad");
        String s = restTemplate.getForObject(INVOKE_URL + "/paymentzk/paymentzk",String.class);
        return s;
    }
}
