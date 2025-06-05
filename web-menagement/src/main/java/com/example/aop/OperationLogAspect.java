package com.example.aop;

import com.example.anno.Log;
import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import com.example.utils.ThreatLocal;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.example.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long start = System.currentTimeMillis();

        // 执行目标方法
        Object result = null;
        Exception ex = null;
        try {
            result = joinPoint.proceed();
            return result;
        } catch (Exception e) {
            ex = e;
            throw e;
        } finally {
            // 记录结束时间
            long end = System.currentTimeMillis();

            // 获取操作人ID
            Integer empId = null;
            String empIdStr = ThreatLocal.getCurrentId();
            if (empIdStr != null) {
                try {
                    log.info("操作人ID: {}", empIdStr);
                    empId = Integer.parseInt(empIdStr);
                } catch (NumberFormatException e) {
                    log.error("操作人ID格式错误", e);
                }
            }
                // 获取方法信息
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                String className = joinPoint.getTarget().getClass().getName();
                String methodName = signature.getName();
                String methodParams = Arrays.toString(joinPoint.getArgs());
                String returnValue = result != null ? result.toString() : (ex != null ? ex.getMessage() : "void");

                // 构建日志对象
                OperateLog logObj = new OperateLog();
                logObj.setOperateEmpId(empId);
                logObj.setOperateTime(LocalDateTime.now());
                logObj.setClassName(className);
                logObj.setMethodName(methodName);
                logObj.setMethodParams(methodParams);
                logObj.setReturnValue(returnValue);
                logObj.setCostTime(end - start);

                // 保存日志
                operateLogMapper.insert(logObj);
            }
        }
    }