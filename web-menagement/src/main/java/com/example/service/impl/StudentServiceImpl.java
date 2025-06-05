package com.example.service.impl;

import com.example.mapper.StudentMapper;
import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentPageQueryParam;
import com.example.service.StudentService;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> findPageStudent(StudentPageQueryParam param) {
        PageHelper.startPage(param.getPage(), param.getPageSize());
        List<Student> list = studentMapper.getStudentList(param);
        long total = studentMapper.getStudentCount(param);
        return new PageResult<>(total, list);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentMapper.findStudentById(id);
    }

    @Override
    public void deleteStudents(List<Long> ids) {
        studentMapper.deleteStudents(ids);
    }

    @Override
    public void updateStudent(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.updateStudent(student);
    }

    @Override
    public void addStudent(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        student.setViolationCount((short)0);
        student.setViolationScore((short)0);
        studentMapper.addStudent(student);
    }

    //违纪处理
    @Override
    public void handleViolation(Long id, Integer score) {
            studentMapper.handleViolation(id, score);

    }
}