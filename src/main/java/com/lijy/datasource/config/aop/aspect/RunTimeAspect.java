package com.lijy.datasource.config.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author lijiayu
 * @date 2019/12/26
 * @description
 */
@Aspect
@Component
@Slf4j
public class RunTimeAspect {

    @Pointcut("@annotation(com.lijy.datasource.config.aop.RunTime)")
    public void runTimeAspect(){}

    @Around("runTimeAspect()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long time = System.currentTimeMillis();
        joinPoint.proceed();
        return System.currentTimeMillis()-time;
    }


    @AfterReturning(pointcut = "runTimeAspect()",returning = "ret")
    public void doAfterReturning(Object ret){
        log.info("方法耗时："+ret+"ms");
    }
}
