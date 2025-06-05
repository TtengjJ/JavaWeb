package com.example.service;

import com.example.pojo.Clazz;
import com.example.pojo.ClazzPageQueryParam;
import com.example.pojo.PageResult;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ClazzService {
    List<Clazz> findAllClazzlist();

    Clazz findClazzById(Integer id);

    void updateClazz(Clazz clazz);

    void deleteClazz(Integer id);

    void addClazz(Clazz clazz);

    //分页查询
    PageResult<Clazz> findPageClazz(ClazzPageQueryParam param);
}
