package com.example.service;

import com.example.pojo.OperateLog;
import com.example.pojo.OperateLogPageQueryParam;
import com.example.pojo.PageResult;

public interface OperateLogService {
    PageResult<OperateLog> pageQuery(OperateLogPageQueryParam param);
}