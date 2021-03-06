package com.lijy.datasource.config.aop;

import com.lijy.datasource.enums.DataSourceKey;

import java.lang.annotation.*;

/**
 * @author lijiayu
 * @date 2019/12/27
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    DataSourceKey value() default DataSourceKey.MASTER;
}
