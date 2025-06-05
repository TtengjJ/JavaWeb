// StudentPageQueryParam.java
package com.example.pojo;

import lombok.Data;

@Data
public class StudentPageQueryParam {
    private String name;    // 姓名
    private String no;      // 学号
    private Integer gender; // 性别
    private Integer clazzId; // 班级ID
    private Integer degree; // 学历
    private Integer page = 1;
    private Integer pageSize = 10;
}