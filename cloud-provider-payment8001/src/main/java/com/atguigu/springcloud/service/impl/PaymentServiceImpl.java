package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.service.PaymentService;
import entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Integer create(Payment payment) {
        return 1;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = new Payment();
        payment.setId(1l);
        payment.setNumbers("123");
        return payment;
    }
}
