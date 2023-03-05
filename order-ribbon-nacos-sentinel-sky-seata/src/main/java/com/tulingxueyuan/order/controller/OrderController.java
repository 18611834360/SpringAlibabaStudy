package com.tulingxueyuan.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tulingxueyuan.order.RocketMQMsgProducer;
import com.tulingxueyuan.order.RocketMQMsgReceiver;
import com.tulingxueyuan.order.mapper.OrderInfoMapper;
import com.tulingxueyuan.order.mapper.StockInfoMapper;
import com.tulingxueyuan.order.pojo.OrderInfo;
import com.tulingxueyuan.order.pojo.StockInfo;
import com.tulingxueyuan.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestHeader;
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

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    RocketMQMsgProducer msgProducer;
    @Autowired
    RocketMQMsgReceiver msgReceiver;

    @Autowired
    OrderService orderService;

    @RequestMapping("/rocketSndMsg")
    @SentinelResource(value = "rocketSndMsg", blockHandler = "flowBlockHandler")
    public String rocketSndMsg() throws InterruptedException {

        System.out.println("准备发送消息");
        String topic = "my-boot-topic";
        String msg = "message from my springboot producer!";
        msgProducer.sendMsg(topic, msg);
        System.out.println("消息发送成功:"+topic+" "+msg);
        return "order-ribbon-sentinel-service:order-service/order/get调用:" + port;
    }

    @RequestMapping("/getByOrderId")
    @GlobalTransactional
    @SentinelResource(value = "getByOrderId", blockHandler = "flowBlockHandler")
    public OrderInfo getByOrderId() {
        System.out.println("selectByPrimaryId!!!!");
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(1);
        orderInfo.setGoodsId(1);
        orderInfo.setOrderName("修改后的33");
        orderInfoMapper.updateByPrimaryKey(orderInfo);

        //本地服务调用

        //远程调用:
        String msg = restTemplate.getForObject("http://order-ribbon-nacos-sentinel-sky-seata-service/order/substock", String.class);


        return orderInfoMapper.selectByPrimaryKey(1);
    }

    @Autowired
    StockInfoMapper stockInfoMapper;
    @RequestMapping("/substock")
    @GlobalTransactional
    @SentinelResource(value = "substock", blockHandler = "flowBlockHandler")
    public StockInfo substock() {
        System.out.println("substock!!!!");
        StockInfo stockInfo = new StockInfo();
        stockInfo.setGoodsId(1);
        stockInfo.setTotalNumber(1000);
        stockInfoMapper.updateByPrimaryKey(stockInfo);
        return stockInfoMapper.selectByPrimaryKey(1);
    }



    @RequestMapping("/head")
    @SentinelResource(value="head",blockHandler="flowBlockHandler")
    public String head(@RequestHeader("X-Request-Color") String color){
        System.out.println("head !");
        String msg = restTemplate.getForObject("http://order-ribbon-sentinel-service/order/get",String.class);
        return "order-service/order/head调用："+port+color;
//        return "order-ribbon-sentinel-service:order-service/order/add调用:"+port;
    }



    @RequestMapping("/add")
    @SentinelResource(value="add",blockHandler="flowBlockHandler")
    public String add(){


        System.out.println("下单成功");
//        String msg = restTemplate.getForObject("http://order-ribbon-sentinel-service/order/get",String.class);
        String s=orderService.getOrderById();
        return "order-service调用："+port+s;
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
