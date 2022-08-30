package com.guli.eduservice.controller;


import com.guli.commonutils.Result;
import com.guli.eduservice.entity.EduTeacher;
import com.guli.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author lipeng
 * @since 2022-08-29
 */
@Api("讲师管理")
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value="所有讲师列表")
    @GetMapping("findAll")
    public Result findAll(){
        List<EduTeacher> list  = eduTeacherService.list(null);
        return Result.success().data("items",list);
    }
    //逻辑删除讲师的方法
    @ApiOperation(value="逻辑删除讲师")
    @DeleteMapping("{id}")
    public Result removeTeacher(
            @ApiParam(name = "id",value = "讲师ID",required = true)
            @PathVariable String id){
        val b = eduTeacherService.removeById(id);
        if(b){
            return Result.success();
        }else {
            return Result.error();
        }
    }

}

