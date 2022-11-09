package com.guli.eduservice.client;

import io.swagger.annotations.Api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@Api(tags = "远程调用")
@FeignClient("service-vod")
@Component
public interface VodClient {
}
