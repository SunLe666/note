package com.sunle.springcloud.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "spring-cloud-producer")
public interface HelloRemote {

    @GetMapping(value = "hello/{name}")
    public String hello(@PathVariable("name") String name);


}
