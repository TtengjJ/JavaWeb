package com.example.service;

import com.example.pojo.ClazzCountOption;
import com.example.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    JobOption empJobData();

    List<Map<String, Object>> empGenderData();


    ClazzCountOption studentCountData();

    List<Map<String, Object>> studentEducationData();
}
