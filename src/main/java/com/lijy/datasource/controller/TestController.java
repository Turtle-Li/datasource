package com.lijy.datasource.controller;

import com.lijy.datasource.config.aop.PrintRecord;
import com.lijy.datasource.config.aop.RunTime;
import com.lijy.datasource.config.aop.TargetDataSource;
import com.lijy.datasource.entity.User;
import com.lijy.datasource.enums.DataSourceKey;
import com.lijy.datasource.service.SendService;
import com.lijy.datasource.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private SendService sendService;

    @GetMapping("list")
    public List<User> getUserList(long s) throws InterruptedException {
        Thread.sleep(s);
        return testService.getUserList();
    }

    public List<User> getMsgFallback(long s){
        return new ArrayList<User>();
    }

    @GetMapping("save")
    @PrintRecord
    public void save(){
        List<User> users = new ArrayList<>();
        for(int i=50;i<100;i++){
            User user = new User().setName("李四"+i+"号").setAge(i).setScale(i);
            users.add(user);
        }
        testService.saveBatch(users);
    }

    @GetMapping("send")
    public void send(String exchange,String routeKey,String message){
        sendService.send(exchange,routeKey,message);
    }

}
