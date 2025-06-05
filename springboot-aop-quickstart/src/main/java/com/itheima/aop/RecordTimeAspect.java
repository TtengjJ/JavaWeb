package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class  RecordTimeAspect {

    @Around("execution(* com.itheima.service.*.*(..))")
    //切面方法
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //开始时间
        long start = System.currentTimeMillis();

        //业务逻辑
        Object result = joinPoint.proceed();


        //结束时间
        long end = System.currentTimeMillis();
        log.info("{}执行时间：{}",joinPoint.getSignature(), start-end);
        return result;
    }

}

