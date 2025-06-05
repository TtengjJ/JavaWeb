package com.example.service.impl;

import com.example.mapper.ClazzMapper;
import com.example.pojo.Clazz;
import com.example.pojo.ClazzPageQueryParam;
import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.service.ClazzService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public List<Clazz> findAllClazzlist() {
        return clazzMapper.findAllClazzInfolist();
    }

    @Override
    public Clazz findClazzById(Integer id) {
        if (id == null) {
            throw new RuntimeException("班级id不能为空");
        }
        return clazzMapper.getClazzInfoById(id);
    }

    @Override
    public void updateClazz(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.updateClazzInfo(clazz);
    }


    @Override
    public void deleteClazz(Integer id) {
        clazzMapper.deleteClazzInfo(id);
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.addClazzInfo(clazz);
    }

    @Override
    public PageResult<Clazz> findPageClazz(ClazzPageQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Clazz> clazzList = clazzMapper.findClazzInfoList(param);
        long total = clazzMapper.getClazzCount(param);
        return new PageResult<>(total,clazzList);
    }


}
