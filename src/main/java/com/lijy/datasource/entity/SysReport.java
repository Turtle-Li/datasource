package com.lijy.datasource.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author lijiayu
 * @date 2019/12/28
 * @description
 */
@Data
@Accessors(chain = true)
public class SysReport {
    private int id;
    private String methodName;
    private String response;
    private String request;
    private LocalDateTime createdAt;
}
