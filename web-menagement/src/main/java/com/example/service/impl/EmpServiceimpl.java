package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.*;
import com.example.service.EmpLogService;
import com.example.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceimpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    //事务连接，注入另一个事务的service层接口
    @Autowired
    private EmpLogService empLogService;

    @Override
    public PageResult<Emp> page(EmpPageQueryParam param) {
        //当前查询总计数
        Integer offset = (param.getPage() - 1) * param.getPageSize();
        long count = empMapper.getEmpCount(param);
        //查询员工信息
        List<Emp> empList = empMapper.getEmpList(offset, param);
        return new PageResult<Emp>(count,empList);
    }

    @Transactional(rollbackFor = {Exception.class})//事务管理,所有异常都回滚
    @Override
    public void save(Emp emp) {
        try {
            //更新时间
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            //保存员工信息
            empMapper.insert(emp);


            //保存员工工作经历
            List<EmpExpr> empExprList = emp.getExprList();
            if(empExprList != null){
                for (EmpExpr empExpr : empExprList) {
                    empExpr.setEmpId(emp.getId());
                    empExprMapper.insert(empExpr);
                }
            }
        } finally {
            //保存日志信息
            EmpLog empLog = new EmpLog( null,LocalDateTime.now(),"新增员工"+emp);
            empLogService.insertLog(empLog);
        }


    }

    @Transactional(rollbackFor = {Exception.class})//事务管理,所有异常都回滚
    @Override
    public void delete(List<Integer> ids) {
        //删除员工基本信息
        empMapper.deleteByIds(ids);

        //删除员工工作经历
        empExprMapper.deleteByExprs(ids);

    }

    @Override
    public Emp  getById(Integer id) {
        //查询员工基本信息
        Emp emp = empMapper.selectById(id);
        //查询员工工作经历
        List<EmpExpr> empExprList = empExprMapper.selectByEmpId(id);
        emp.setExprList(empExprList);
        return emp;
    }

    @Transactional(rollbackFor= Exception.class)
    @Override
    public void update(Emp emp) {
        //更新员工基本信息
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
        //更新员工工作经历
        List<EmpExpr> empExprList = emp.getExprList();
        if(empExprList != null){
            for (EmpExpr empExpr : empExprList) {
                empExpr.setEmpId(emp.getId());
                empExprMapper.insert(empExpr);
            }
        }
    }

}