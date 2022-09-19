package com.guli.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.commonutils.Result;
import com.guli.eduservice.entity.EduTeacher;
import com.guli.eduservice.entity.vo.TeacherQuery;
import com.guli.eduservice.service.EduTeacherService;
import com.guli.servicebase.config.exceptionhandler.GuliException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
@CrossOrigin //解决跨域
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

    //分页查询讲师的方法
    @ApiOperation(value="分页查询")
    @GetMapping("pageTeacher/{current}/{limit}")
    public Result pageListTeacher(@ApiParam(name = "current",value = "当前页",required = true)
                                  @PathVariable long current,
                                  @ApiParam(name = "limit",value = "显示数",required = true)
                                  @PathVariable long limit){
        //创建page对象
        Page<EduTeacher> pageTeacher = new Page<>(current,limit);
        try {
            int i = 1/0;
        }catch (Exception e){
            //执行自定义异常
            throw new GuliException(20001,"执行了自定义异常处理。。");
        }
        //调用方法实现分页
        //调用方法时候，底层封装到pageTeacher对象里面
        eduTeacherService.page(pageTeacher,null);
        long total = pageTeacher.getTotal();//总记录数
        List<EduTeacher> records = pageTeacher.getRecords();//数据list集合
       /* Map map = new HashMap<>();
        map.put("total",total);
        map.put("records",records);
        return Result.success().data(map);*/
        return Result.success().data("total",total).data("records",records);
    }

    @ApiOperation(value = "分页条件查询")
    @PostMapping("pageTeacherConditon/{current}/{limit}")
    public Result pageTeacherCondition(@ApiParam(name = "current",value = "当前页",required = true)
                                       @PathVariable long current,
                                       @ApiParam(name = "limit",value = "显示数",required = true)
                                       @PathVariable long limit,
                                       @ApiParam(name="teacherQuery",value = "条件接收实体",required = false)
                                       @RequestBody(required = false) TeacherQuery teacherQuery){
        //创建page对象
        Page<EduTeacher> teacherPage = new Page<>(current,limit);
        eduTeacherService.pageQuery(teacherPage,teacherQuery);
        long total = teacherPage.getTotal();//总记录数
        List<EduTeacher> list = teacherPage.getRecords();//数据list集合
        return Result.success().data("total",total).data("list",list);
    }

    @ApiOperation(value = "添加讲师")
    @PostMapping("addTeacher")
    public Result addTeacher(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if(save){
            return Result.success();
        }else {
            return Result.error();
        }
    }

    @ApiOperation(value = "根据讲师id进行查询")
    @GetMapping("getTeacher/{id}")
    public Result getTeacher(@PathVariable String id){
        EduTeacher teacher = eduTeacherService.getById(id);
        return Result.success().data("teacher",teacher);
    }

    @ApiOperation(value = "修改讲师")
    @PostMapping("updateTeacher")
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = eduTeacherService.updateById(eduTeacher);
        if(flag){
            return Result.success();
        }else {
            return Result.error();
        }
    }














}

