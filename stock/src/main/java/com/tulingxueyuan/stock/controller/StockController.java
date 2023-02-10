package com.tulingxueyuan.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stock")
public class StockController {

//    @Value("${server.port}")
//    String port;

    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("进入stock-service，库存扣减成功");
//        return "stock-service:nacos 扣减库存 分布式!!!:"+port;
        return "stock-service:nacos 扣减库存 分布式!!!:";

    }
}
