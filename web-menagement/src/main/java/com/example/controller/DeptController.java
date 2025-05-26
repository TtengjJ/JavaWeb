package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping
    public Result list(){
        //System.out.println("查询部门数据");
        log.info("查询部门数据");
        List<Dept> deptList= deptService.findAll();
        return Result.success(deptList);
    }

    @DeleteMapping
    public Result delete(Integer id) {
        //System.out.println("删除部门数据"+id);
        log.info("删除部门数据"+id);
        deptService.deleteById(id);
        return Result.success();
    }

    //RequestBody:请求体
    @PostMapping
    public Result save(@RequestBody Dept dept) {
        //System.out.println("保存部门数据"+dept);
        log.info("保存部门数据"+dept);
        deptService.save(dept);
        return Result.success();
    }

    //根据id查询部门
    @GetMapping("/{id}")
    //路径参数PathVariable
    public Result findById(@PathVariable Integer id) {
        //System.out.println("根据id查询部门"+id);
        log.info("根据id查询部门"+id);

        //返回data

        //不确定是Dept返回Object
        //return Result.success(deptService.findById(id));

        //确定是Dept返回Dept
        Dept dept=deptService.findById(id);
        return Result.success(dept);
    }

    //更新name和updateTime,根据id
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        //System.out.println("更新部门数据"+dept);
        log.info("更新部门数据"+dept);
        deptService.update(dept);
        return Result.success();
    }
}
