package com.example.controller;

import com.example.pojo.OperateLog;
import com.example.pojo.OperateLogPageQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("/page")
    public Result page(OperateLogPageQueryParam param){
        log.info("分页查询日志数据");
        PageResult<OperateLog> pageResult = operateLogService.pageQuery(param);
        return Result.success(pageResult);
    }
}
