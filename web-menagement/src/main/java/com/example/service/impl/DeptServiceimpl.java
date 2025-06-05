package com.example.service.impl;

import com.example.exception.BusinessException;
import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return  deptMapper.findAll();
    }

    //如果部门有员工不能删除
    @Override
    public void deleteById(Integer id) {
        if (deptMapper.findEmpByDeptId(id) > 0) {
            //提示前端
            throw new BusinessException("该部门有员工，不能删除");
            }
        deptMapper.deleteById(id);
    }

    @Override
    public void save(Dept dept) {
        //更新当前时间
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
