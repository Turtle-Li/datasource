package com.lijy.datasource.service.impl;

import com.lijy.datasource.entity.User;
import com.lijy.datasource.service.TestService;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
@SpringBootTest
@Slf4j
class TestServiceImplTest {

    @Autowired
    private TestService testService;

    @Autowired
    private DataSource dataSource;

    @Test
    void getUserList() {
        System.out.println(testService.getUserList());
    }

    @Test
    void saveUser(){
        List<User> users = new ArrayList<>();
        for(int i=50;i<100;i++){
            User user = new User().setName("李四"+i+"号").setAge(i).setScale(i);
            users.add(user);
        }
        testService.saveBatch(users);
    }

    @Test
    void contextLoads() throws SQLException {
        log.info("dataSource:"+dataSource.getClass());
        Connection connection = dataSource.getConnection();
        log.info("connection:"+connection);
        connection.close();
    }
}