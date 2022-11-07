package com.guli.eduservice.controller;


import com.guli.commonutils.Result;
import com.guli.eduservice.entity.subject.OneSubject;
import com.guli.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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
    @ApiOperation("添加课程分类")
    @PostMapping("addSubject")
    public Result addSubject(MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return Result.success();
    }

    @ApiOperation("课程分类列表（树形）")
    @GetMapping("getAllSubject")
    public Result getAllSubject(){
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return Result.success().data("list",list);
    }

}

