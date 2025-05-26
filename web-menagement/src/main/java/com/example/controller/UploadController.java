package com.example.controller;


import com.example.pojo.Result;
import com.example.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.util.Objects;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    private  AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件: {}", file.getOriginalFilename());
        // TODO: 调用阿里云OSS上传文件
        //返回文件访问路径url,前端直接访问该url即可下载文件
        String url= aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("上传文件成功: {}", url);
        return Result.success(url);
    }
}
