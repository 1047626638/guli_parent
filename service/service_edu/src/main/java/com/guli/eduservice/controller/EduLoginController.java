package com.guli.eduservice.controller;

import com.guli.commonutils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api("登录")
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin //解决跨域
public class EduLoginController {

    @ApiOperation("登录")
    @PostMapping("login")
    public Result login(){
        return Result.success().data("token","admin");
    }

    @ApiOperation("获取信息")
    @GetMapping("info")
    public Result info(){
        return Result.success().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
