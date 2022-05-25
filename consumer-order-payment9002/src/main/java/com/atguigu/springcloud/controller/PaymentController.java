package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.lb.LoadBalancer;
import com.ctc.wstx.shaded.msv_core.util.Uri;
import entities.CommonResult;
import entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RequestMapping("consumer/order")
@RestController
@Slf4j
public class PaymentController {

//    private static final String HTTPHOST = "http://localhost:8001/";
    private static final String HTTPHOST = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/getData")
    public CommonResult<Payment> getData(){
        log.info("获取数据。");
        return  new CommonResult(200,"success",restTemplate.getForObject(HTTPHOST + "/api/getData",CommonResult.class));
    }

    /**
     * 自定义负载均衡
     * @return
     */
    @GetMapping("/zdyfzjh")
    public String zdyfzjh(){
        log.info("自定义负载均衡");
        List<ServiceInstance>  instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (CollectionUtils.isEmpty(instances)){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return  restTemplate.getForObject(uri + "/api/getPost",String.class);
    }
}
