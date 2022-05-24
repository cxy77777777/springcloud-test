package com.atguigu.springcloud.service;


import entities.Payment;

public interface PaymentService {

    public Integer create(Payment payment);

    public Payment getPaymentById(Long id);
}
