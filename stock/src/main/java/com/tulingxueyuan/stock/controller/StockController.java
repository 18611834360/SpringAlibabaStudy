package com.tulingxueyuan.stock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/stock")
public class StockController {
    @RequestMapping("/reduct")
    public String reduct(){
        System.out.println("加上了nacos，库存扣减成功");
        return "stock-service:nacos 扣减库存 分布式!!!";
    }
}
