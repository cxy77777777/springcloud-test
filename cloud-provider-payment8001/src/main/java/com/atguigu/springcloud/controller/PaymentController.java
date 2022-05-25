package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping("api")
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/getData")
    public CommonResult<Payment> getData(){
        log.info("获取数据");
        return  new CommonResult(200,"success8001",paymentService.getPaymentById(1l));
    }

    @GetMapping("/getServices")
    public CommonResult<Payment> getServices(){
        log.info("获取注册中心服务-discovery");
        List<String> services = discoveryClient.getServices();
        for (String s:services) {
            log.info("'services:'" + s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:instances) {
            log.info(serviceInstance.getServiceId() + ";" + serviceInstance.getHost()+
                    ";" +serviceInstance.getPort() + ";" + serviceInstance.getInstanceId() + ";"
            +serviceInstance.getUri());
        }
        return  new CommonResult(200,"success8001",paymentService.getPaymentById(1l));
    }

    @GetMapping("/getPost")
    public String getPost(){
        log.info("getPost");
        return  serverPort;
    }

    @GetMapping("/payment/feign")
    public CommonResult<Payment> getFeign(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new CommonResult(200,"success8001",paymentService.getPaymentById(1l));
    }
}
