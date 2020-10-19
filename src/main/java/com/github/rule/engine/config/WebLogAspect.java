package com.github.rule.engine.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Aspect
@Order(5)
@Slf4j
@Component
public class WebLogAspect {


    ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();

    @Pointcut("execution(public * com.github.rule.engine.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        Map<String, String> dataMap = new HashMap();
        dataMap.put("startTime", String.valueOf(System.currentTimeMillis()));
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        dataMap.put("url", request.getRequestURL().toString());
        threadLocal.set(dataMap);
        //log.info("URL : {}", request.getRequestURL().toString());
        //log.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        //log.info("RESPONSE : " + ret);
        Map<String, String> dataMap = threadLocal.get();
        log.info(">>>接口:{} -耗时: {}ms", dataMap.get("url"),
                (System.currentTimeMillis() - Long.valueOf(dataMap.get("startTime"))));
    }


}
