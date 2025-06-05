package com.example.exception;

import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理业务异常
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e){
        log.error("业务异常：{}", e.getMessage());
        return Result.error(e.getMessage());
    }

    // 处理SQL异常
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        log.error("系统异常：", e);
        return Result.error("系统繁忙，请稍后重试");
    }
}