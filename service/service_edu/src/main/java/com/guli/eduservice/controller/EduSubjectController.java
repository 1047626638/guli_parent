package com.guli.eduservice.controller;


import com.guli.commonutils.Result;
import com.guli.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author lipeng
 * @since 2022-11-06
 */
@Api(tags = {"课程分类"})
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;

    //添加课程分类
    //获取上传过来文件，把文件读取出来
    @PostMapping("addSubject")
    @ApiOperation("添加课程分类")
    public Result addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return Result.success();
    }
}

