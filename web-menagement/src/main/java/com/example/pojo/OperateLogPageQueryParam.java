package com.example.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperateLogPageQueryParam {
    private Integer page;
    private Integer pageSize;
    private Integer id;
    private Integer operateEmpId;
    private LocalDateTime operateTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private Long costTime;
    private String operateEmpName; // 操作人姓名
    public Integer getOffset() {
        if (page == null || page < 1) return 0;
        if (pageSize == null || pageSize < 1) return 0;
        return (page - 1) * pageSize;
    }
}