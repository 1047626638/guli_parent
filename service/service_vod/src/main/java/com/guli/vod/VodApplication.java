package com.guli.vod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.guli"})
public class VodApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(VodApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(VodApplication.class, args);
        LOGGER.info("ヾ(◍°∇°◍)ﾉﾞ    VodApplication server 启动成功      ヾ(◍°∇°◍)ﾉﾞ");
    }
}
