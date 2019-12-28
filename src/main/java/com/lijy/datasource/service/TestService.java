package com.lijy.datasource.service;


import com.lijy.datasource.entity.User;

import java.util.List;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
public interface TestService {
    List<User> getUserList();

    void saveUser(User user);

    void saveOrUpdateUserList(List<User> users);

    void saveBatch(List<User> users);
}
