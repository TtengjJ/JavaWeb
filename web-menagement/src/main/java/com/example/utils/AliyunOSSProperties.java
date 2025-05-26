package com.example.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss") //配置文件中前缀为aliyun.oss的属性会自动映射到这个类中
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}
