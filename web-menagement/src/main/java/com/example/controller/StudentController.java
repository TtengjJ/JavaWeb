package com.example.controller;

import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.pojo.Student;
import com.example.pojo.StudentPageQueryParam;
import com.example.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result findPageStudent(StudentPageQueryParam param) {
        log.info("学生分页查询：{}", param);
        PageResult<Student> pageResult = studentService.findPageStudent(param);
        return Result.success(pageResult);
    }

    //根据学生id查询学生信息
    @GetMapping("/{id}")
    public Result findStudentById(@PathVariable Long id) {
        log.info("根据id查询学生信息：{}", id);
        Student student = studentService.findStudentById(id);
        return Result.success(student);
    }

    //批量删除学生信息
    @DeleteMapping("/{ids}")
    public Result deleteStudents(@PathVariable List<Long> ids) {
        log.info("批量删除学生信息：{}", ids);
        studentService.deleteStudents(ids);
        return Result.success();
    }

    //修改学生信息
    @PutMapping
    public Result updateStudent(@RequestBody Student student) {
        log.info("修改学生信息：{}", student);
        studentService.updateStudent(student);
        return Result.success();
    }

    //添加学生信息
    @PostMapping
    public Result addStudent(@RequestBody Student student) {
        log.info("添加学生信息：{}", student);
        studentService.addStudent(student);
        return Result.success();
    }

    //违纪处理
    @PutMapping("/violation/{id}/{score}")
    public Result handleViolation(@PathVariable Long id, @PathVariable Integer score) {
        log.info("违纪处理：学生id：{}，扣除分数：{}", id, score);
        studentService.handleViolation(id, score);
        return Result.success();
    }
}