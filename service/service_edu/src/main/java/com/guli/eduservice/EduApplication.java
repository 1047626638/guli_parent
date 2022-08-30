package com.guli.eduservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = {"com.guli"})
public class EduApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(EduApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
        LOGGER.info("ヾ(◍°∇°◍)ﾉﾞ    EduApplication server 启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }
}
