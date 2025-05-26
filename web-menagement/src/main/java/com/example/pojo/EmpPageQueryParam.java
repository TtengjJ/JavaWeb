package com.example.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//员工分页查询参数
@Data
public class EmpPageQueryParam {
    private Integer page;        // 页码
    private Integer pageSize;    // 每页显示条数
    private String name;         // 姓名
    private Integer gender;      // 性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate beginDate; // 入职开始日期
    private LocalDate endDate;   // 入职结束日期
}