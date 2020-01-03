package com.lijy.datasource.service.impl;

import com.lijy.datasource.entity.User;
import com.lijy.datasource.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author lijiayu
 * @date 2020/1/2
 * @description
 */
@Service
@Slf4j
public class SendServiceImpl implements SendService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void send(String exchange,String routeKey,Object message){
//        rabbitTemplate.convertAndSend("direct","direct");

//        rabbitTemplate.convertAndSend("exchange","topic.message","message");
//
//        rabbitTemplate.convertAndSend("exchange","topic.m","messages");

//        rabbitTemplate.convertAndSend("fanoutExchange","","fanout");

        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(exchange, routeKey, message, correlationData);
        log.info("SendMessageServiceImpl() >>> 发送消息到RabbitMQ, 消息内容: " + message);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean isSendSuccess, String s) {
        log.info("confirm回调方法>>>>>>>>>>>>>回调消息ID为: " + correlationData.getId());

        if (isSendSuccess) {
            log.info("confirm回调方法>>>>>>>>>>>>>消息发送成功");
        } else {
            log.info("confirm回调方法>>>>>>>>>>>>>消息发送失败" + s);
        }
    }
}
