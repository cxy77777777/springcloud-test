package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String PaymentInfo(Long id){
        return "线程池：" + Thread.currentThread().getName() + "PaymentInfo,id:" + id + "哈哈O(∩_∩)O！";
    }

    /**
     * 耗时访问呢
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "PaymentInfo_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String PaymentInfo_timeOut(Long id){
        int i = 2;//测试超时异常
        int ss = 10/0;//测试运行异常
        try {
            TimeUnit.SECONDS.sleep(i);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "PaymentInfo_timeOut,id:" + id + "哈哈O(∩_∩)O！耗时（s）：" + i;
    }

    public String PaymentInfo_timeOutHandler(Long id){
        return "线程池：" + Thread.currentThread().getName() + "PaymentInfo_timeOutHandler,id:" + id + "降级了！";
    }
}
