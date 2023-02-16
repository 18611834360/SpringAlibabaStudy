package com.tulingxueyuan.order.service;

import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.stereotype.Service;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/15上午11:00
 **/

@Service
public class OrderService {
    @Trace
    public String getOrderById(){
        System.out.println("get order by id");
        return "orderid is ： 99999999";
    }
}
