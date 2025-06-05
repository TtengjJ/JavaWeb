package com.example.controller;

import com.example.pojo.ClazzCountOption;
import com.example.pojo.JobOption;
import com.example.pojo.Result;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {
    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result empJobData() {
        log.info("统计各职位员工人数");
        JobOption jobOption= reportService.empJobData();
        return Result.success(jobOption);
    }

    //统计性别
    @GetMapping("/empGenderData")
    public Result empGenderData() {
        log.info("统计各性别员工人数");
        List<Map<String,Object>>genderList =  reportService.empGenderData();
        return Result.success(genderList);
    }


    //班级人数统计
    @GetMapping("/studentCountData")
    public Result studentCountData() {
        log.info("统计各班级人数");
        ClazzCountOption genderList =  reportService.studentCountData();
        return Result.success(genderList);
    }

    //学生学历统计
     @GetMapping("/studentDegreeData")
    public Result studentEducationData() {
        log.info("统计各学生学历人数");
        List<Map<String,Object>>genderList =  reportService.studentEducationData();
        return Result.success(genderList);
     }
}
