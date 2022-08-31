package com.guli.servicebase.config.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor //生成有参构造方法
@NoArgsConstructor //生成无参构造方法
public class GuliException extends RuntimeException{
    @ApiModelProperty("状态码")
    private Integer code;
    @ApiModelProperty("异常信息")
    private String msg;


}
