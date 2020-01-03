package com.lijy.datasource.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 6806933282289315035L;

    private int id;
    private String name;
    private int age;
    private int scale;
}
