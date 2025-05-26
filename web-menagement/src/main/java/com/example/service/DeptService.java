package com.example.service;

import com.example.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();

    void deleteById(Integer id);

// 保存部门信息
    void save(Dept dept);


    Dept findById(Integer id);

    void update(Dept dept);
}
