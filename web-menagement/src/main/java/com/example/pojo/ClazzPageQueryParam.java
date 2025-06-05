package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ClazzPageQueryParam {
//    "rows": [
//    {
//        "id": 0,
//            "name": "string",
//            "room": "string",
//            "beginDate": "2019-08-24",
//            "endDate": "2019-08-24",
//            "masterId": 0,
//            "masterName": "string",
//            "subject": 0,
//            "createTime": "2019-08-24T14:15:22.123Z",
//            "updateTime": "2019-08-24T14:15:22.123Z"
//    }
    private Integer page;
    private Integer pageSize;
    private String name;
    private String room;
    private LocalDate beginDate;
    private LocalDate endDate;
    private Integer masterId;
    private String masterName;
    private Integer subject;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
