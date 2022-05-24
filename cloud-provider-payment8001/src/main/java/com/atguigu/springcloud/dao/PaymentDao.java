package com.atguigu.springcloud.dao;

import entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    public Integer create(Payment payment);

    public Payment getPaymentById(Long id);
}
