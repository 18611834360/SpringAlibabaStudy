package com.tulingxueyuan.order;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "my-producer-group-test",topic="my-boot-topic")
public class RocketMQMsgReceiver implements RocketMQListener<String> {
    @Override
    public void onMessage(String message){
        System.out.println("接收到的消息："+message);
    }


}