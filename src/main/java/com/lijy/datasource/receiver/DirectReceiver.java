package com.lijy.datasource.receiver;

import com.lijy.datasource.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author lijiayu
 * @date 2020/1/2
 * @description
 */
@Component
@RabbitListener(queues = "direct")
public class DirectReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("Receiver : " + msg);
    }
}
