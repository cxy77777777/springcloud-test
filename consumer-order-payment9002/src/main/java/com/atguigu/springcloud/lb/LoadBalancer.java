package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 自定义负载均衡
 */
public interface LoadBalancer {
    ServiceInstance instances (List<ServiceInstance> serviceInstances);
}
