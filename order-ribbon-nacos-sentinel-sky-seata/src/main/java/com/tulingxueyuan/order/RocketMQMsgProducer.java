package com.tulingxueyuan.order;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:gaojinjun
 * @date: 2023022023/2/17下午10:41
 **/
@Component
public class RocketMQMsgProducer {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;
    public void  sendMsg(String topic,String message){
        rocketMQTemplate.convertAndSend(topic,message);
        System.out.println("test");
    }
}
