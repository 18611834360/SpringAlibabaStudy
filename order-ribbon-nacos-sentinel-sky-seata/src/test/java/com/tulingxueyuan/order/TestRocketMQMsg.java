//package com.tulingxueyuan.order;
//
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
///**
// * @author:gaojinjun
// * @date: 2023022023/2/17下午11:08
// **/
//@SpringBootTest
//public class TestRocketMQMsg {
//
//    @Autowired
//    RocketMQMsgProducer msgProducer;
//
//    @Test
//    public void contextloads(){
//
//    }
//
//    @Test
//    public void testRcvMsg(){
//
//    }
//    @Test
//    public void testSndMsg(){
//        System.out.println("准备发送消息");
//
//        String topic= "my-boot-topic";
//        String msg= "message from my springboot producer!";
//        msgProducer.sendMsg(topic,msg);
//        System.out.println("消息发送成功");
//    }
//}
