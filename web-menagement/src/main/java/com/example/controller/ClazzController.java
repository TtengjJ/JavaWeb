package com.example.controller;


import com.example.pojo.Clazz;
import com.example.pojo.ClazzPageQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.ClazzService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    //分页查询
    @GetMapping
    public Result findPageClazz(ClazzPageQueryParam param){
        log.info("分页查询班级信息{}",param);
        PageResult<Clazz> pageInfo = clazzService.findPageClazz(param);
        return Result.success(pageInfo);
    }
    //查询所有班级
    @GetMapping("/list")
    public Result findAllClazz() {
        log.info("查询所有班级");
        List<Clazz> clazzList  = clazzService.findAllClazzlist();
        return Result.success(clazzList);
    }

    //根据id查询班级
    @GetMapping("/{id}")
    public Result findClazzById(@PathVariable Integer id) {
        log.info("根据id查询班级: {}", id);
        Clazz clazz = clazzService.findClazzById(id);
        return Result.success(clazz);
    }


    //修改班级
    @PutMapping
    public Result updateClazz(@RequestBody Clazz clazz) {
        log.info("修改班级");
        clazzService.updateClazz(clazz);
        return Result.success();
    }

    //删除班级
    @DeleteMapping("/{id}")
    public Result deleteClazz(@PathVariable Integer id) {
        log.info("删除班级");
        clazzService.deleteClazz(id);
        return Result.success();
    }

    //添加班级
    @PostMapping
    public Result addClazz(@RequestBody Clazz clazz) {
        log.info("添加班级");
        clazzService.addClazz(clazz);
        return Result.success();
    }


}
