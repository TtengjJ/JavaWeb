package com.example.service;

import com.example.pojo.PageResult;
import com.example.pojo.Student;
import com.example.pojo.StudentPageQueryParam;

import java.util.List;

public interface StudentService {
    PageResult<Student> findPageStudent(StudentPageQueryParam param);
    Student findStudentById(Long id);
    void deleteStudents(List<Long> ids);
    void updateStudent(Student student);
    void addStudent(Student student);

    void handleViolation(Long id, Integer score);
}