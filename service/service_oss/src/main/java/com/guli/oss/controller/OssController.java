package com.guli.oss.controller;

import com.guli.commonutils.Result;
import com.guli.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduoss/fileoss")
@Api("文件上传到阿里云OSS")
public class OssController {
    @Autowired
    private OssService ossService;
    @PostMapping
    @ApiOperation("头像上传到OSS")
    public Result uploadOssFile(MultipartFile file){
        String url = ossService.uploadFileAvatar(file);
        return Result.success().data("url",url);
    }

}
