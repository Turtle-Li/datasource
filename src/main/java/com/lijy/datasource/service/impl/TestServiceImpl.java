package com.lijy.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lijy.datasource.config.aop.RunTime;
import com.lijy.datasource.config.aop.TargetDataSource;
import com.lijy.datasource.dao.UserMapper;
import com.lijy.datasource.entity.User;
import com.lijy.datasource.enums.DataSourceKey;
import com.lijy.datasource.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
@Service
public class TestServiceImpl extends ServiceImpl<UserMapper,User> implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList(){
        return userMapper.selectList(null);
    }

    @Override
    public void saveUser(User user){

    }

    @Override
    @RunTime
    public void saveOrUpdateUserList(List<User> users){
        this.saveBatch(users);
    }

    @Override
    @RunTime
    @Transactional
    public void saveBatch(List<User> users){
        userMapper.insertBatch(users);
    }
}
