package com.example.service.impl;

import com.example.mapper.OperateLogMapper;
import com.example.pojo.OperateLog;
import com.example.pojo.OperateLogPageQueryParam;
import com.example.pojo.PageResult;
import com.example.service.OperateLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<OperateLog> pageQuery(OperateLogPageQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<OperateLog> list = operateLogMapper.pageQuery(param);
        long total = operateLogMapper.pageQueryCount(param);
        return new PageResult<>(total, list);
    }
}