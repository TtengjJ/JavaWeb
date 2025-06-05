package com.example.controller;

import com.example.pojo.Emp;
import com.example.pojo.EmpPageQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    //分页查询
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(EmpPageQueryParam param){
        log.info("分页查询：{}", param);
        PageResult<Emp> empPageResult = empService.page( param);
        return Result.success(empPageResult);
    }

    //新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}", emp);
        empService.save(emp);
        return Result.success();
    }

    //删除员工
    @DeleteMapping
    public Result delete(@RequestParam List <Integer> ids){
        log.info("删除员工：{}", ids);
        empService.delete(ids);
        return Result.success();
    }


    //查询回显
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("查询员工：{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    //修改员工
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工：{}", emp);
        empService.update(emp);
        return Result.success();
    }



}
