package com.guli.eduservice.controller;


import com.guli.eduservice.entity.EduTeacher;
import com.guli.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author lipeng
 * @since 2022-08-29
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @RequestMapping("findAll")
    public List<EduTeacher> findAll(){
        List<EduTeacher> list  = eduTeacherService.list(null);
        return list;
    }

}

