package com.lijy.datasource.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lijiayu
 * @date 2020/1/2
 * @description
 */
@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessagesReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Receivers : " + msg);
    }
}
