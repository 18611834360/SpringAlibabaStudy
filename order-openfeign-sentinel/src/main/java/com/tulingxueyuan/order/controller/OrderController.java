package com.tulingxueyuan.order.controller;

import com.tulingxueyuan.order.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
//    RestTemplate restTemplate1;
    StockFeignService stockFeignService;


    @RequestMapping("/add")
    public String add(){
        System.out.println("进入order.add......!");
        //非nacos注册中心服务调用方式
        //String msg = restTemplate1.getForObject("http://localhost:8021/stock/reduct",String.class);

        //集成了nacos注册中心服务调用方式
//        String msg = restTemplate1.getForObject("http://stock-service/stock/reduct",String.class);

        //openFeign调用方法
        String msg = stockFeignService.reduct2();
        System.out.println("/order/add 成功......!");

        return "order-openfeign-sentinel /order/add success："+msg;
    }
}
