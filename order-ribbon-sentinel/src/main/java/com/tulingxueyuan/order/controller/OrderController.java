package com.tulingxueyuan.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;
    @Value("${server.port}")
    String port;

    @RequestMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String msg = restTemplate.getForObject("http://order-ribbon-sentinel-service/order/get",String.class);
        return "order-service调用："+port+msg;
//        return "order-ribbon-sentinel-service:order-service/order/add调用:"+port;
    }

    @RequestMapping("/get")
    @SentinelResource(value="get",blockHandler="flowBlockHandler")

    public String get() throws  InterruptedException{
        System.out.println("查询订单成功");
        return "order-ribbon-sentinel-service:order-service/order/get调用:"+port;
    }

    @RequestMapping("/flow")
    @SentinelResource(value="flow",blockHandler="flowBlockHandler")
    public String flow(){
        System.out.println("下单成功");

        return ":order-ribbon-sentinel-service:order-service/add/flow调用:"+port;
    }

    @RequestMapping("/flowThread")
    @SentinelResource(value="flowThread",blockHandler="flowBlockHandler")
    public String flowThread() throws InterruptedException{
        TimeUnit.SECONDS.sleep(2);
        System.out.println("下单成功");

        return ":order-ribbon-sentinel-service:order-service/add/flowThread调用:"+port;
    }

    @RequestMapping("/myerror")
    @SentinelResource(value="myerror",blockHandler="flowBlockHandler")
    public String myerror() throws InterruptedException{
        System.out.println("myerror访问下单成功");
        int a =1/0;

        return ":order-ribbon-sentinel-service:order-service/add/myerror调用:"+port;
    }

    public String flowBlockHandler(BlockException e){
        return "order-ribbon-sentinel-service:order-service/add/flow 流控";
    }
}
