package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.EmpPageQueryParam;
import com.example.pojo.LoginInfo;
import com.example.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageResult<Emp> page(EmpPageQueryParam param);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getById(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}
