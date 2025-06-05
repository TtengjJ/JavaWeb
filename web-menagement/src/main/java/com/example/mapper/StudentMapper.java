package com.example.mapper;

import com.example.pojo.Student;
import com.example.pojo.StudentPageQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
     List<Map<String, Object>> studentEducationData();

    long getStudentCount(StudentPageQueryParam param);
    List<Student> getStudentList(StudentPageQueryParam param);
    Student findStudentById(Long id);
    void deleteStudents(List<Long> ids);
    void updateStudent(Student student);
    void addStudent(Student student);

    void handleViolation(Long id, Integer score);
}