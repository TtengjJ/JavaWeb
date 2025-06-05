package com.example.service.impl;

import com.example.mapper.ClazzMapper;
import com.example.mapper.EmpMapper;
import com.example.mapper.StudentMapper;
import com.example.pojo.ClazzCountOption;
import com.example.pojo.JobOption;
import com.example.pojo.Student;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceimpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption empJobData() {//特定JobOption封装类
        List<Map<String, Object>> jobData = empMapper.empJobData();
        //封装数据
        //提取职业
        List<String> jobList = jobData.stream().map(m -> (String) m.get("jobName")).toList();
        //提取人数
        List<Object> countList = jobData.stream().map(m -> m.get("count")).toList();
        return new JobOption(jobList, countList);
    }

    @Override
    public List<Map<String, Object>> empGenderData() {
        return empMapper.empGenderData();
//        //封装数据
//        //统计性别
//        List<String> genderList = genderData.stream().map(m -> (String) m.get("gender")).toList();
//        //统计人数
//        List<Object> countList = genderData.stream().map(m -> m.get("count")).toList();
//        return genderData;
    }

    @Override
    public ClazzCountOption studentCountData() {
        List<Map<String, Object>> studentCountData = clazzMapper.studentCountData();
        //提取班级
        List<String> clazzList = studentCountData.stream().map(m -> (String) m.get("name")).toList();
        //提取人数
        List<Object> countList = studentCountData.stream().map(m -> m.get("value")).toList();
        return new ClazzCountOption(clazzList, countList);
    }

    @Override
    public List<Map<String, Object>> studentEducationData() {
        return  studentMapper.studentEducationData();
    }


}
