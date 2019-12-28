package com.lijy.datasource.entity;


import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
@Data
@Accessors(chain = true)
public class User {
    private int id;
    private String name;
    private int age;
    private int scale;
}
