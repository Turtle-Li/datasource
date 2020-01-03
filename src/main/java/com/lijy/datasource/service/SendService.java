package com.lijy.datasource.service;

import com.lijy.datasource.entity.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author lijiayu
 * @date 2020/1/2
 * @description
 */
public interface SendService extends RabbitTemplate.ConfirmCallback {

    public void send(String exchange,String routeKey,Object message);
}
