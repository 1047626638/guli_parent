package com.guli.oss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages = {"com.guli"})
public class OssApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OssApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(OssApplication.class, args);
        LOGGER.info("ヾ(◍°∇°◍)ﾉﾞ    OssApplication server 启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }
}
