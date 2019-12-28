package com.lijy.datasource.config.aop.aspect;

import com.alibaba.fastjson.JSONObject;
import com.lijy.datasource.dao.SysReportMapper;
import com.lijy.datasource.entity.SysReport;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperMethod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author lijiayu
 * @date 2019/12/28
 * @description
 */
@Aspect
@Component
@Slf4j
public class PrintReportAspect {

    @Autowired
    private SysReportMapper sysReportMapper;

    @Pointcut("@annotation(com.lijy.datasource.config.aop.PrintRecord)")
    public void printRecord(){}

    @Around("printRecord()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object res = joinPoint.proceed();
        log.info("开始保存日志————————————————————————————————");
        SysReport sysReport = new SysReport();
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature)signature;
        sysReport.setMethodName(joinPoint.getTarget().getClass().getName()+":"+joinPoint.getTarget().getClass().getMethod(ms.getName(),ms.getParameterTypes()).getName())
                 .setResponse(joinPoint.getArgs().length==0?null:JSONObject.toJSONString(joinPoint.getArgs()))
                 .setRequest(res==null?null:JSONObject.toJSONString(res));
        sysReportMapper.insert(sysReport);
        log.info(sysReport.toString());
        log.info("日志保存结束—————————————————————————————————");
        return res;
    }

}
