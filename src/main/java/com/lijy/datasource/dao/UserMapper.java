package com.lijy.datasource.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lijy.datasource.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> getUserList();

    void insertBatch(@Param("users") List<User> users);
}
