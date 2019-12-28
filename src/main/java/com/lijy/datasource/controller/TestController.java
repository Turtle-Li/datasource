package com.lijy.datasource.controller;

import com.lijy.datasource.config.aop.TargetDataSource;
import com.lijy.datasource.entity.User;
import com.lijy.datasource.enums.DataSourceKey;
import com.lijy.datasource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("list")
    @TargetDataSource(DataSourceKey.SLAVE)
    public List<User> getUserList(){
        return testService.getUserList();
    }

    @GetMapping("save")
    @TargetDataSource(DataSourceKey.SLAVE)
    public void save(){
        List<User> users = new ArrayList<>();
        for(int i=50;i<100;i++){
            User user = new User().setName("李四"+i+"号").setAge(i).setScale(i);
            users.add(user);
        }
        testService.saveBatch(users);
    }

}
