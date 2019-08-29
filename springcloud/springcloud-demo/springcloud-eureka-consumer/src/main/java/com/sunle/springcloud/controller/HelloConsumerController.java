package com.sunle.springcloud.controller;

import com.sunle.springcloud.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloConsumerController {

    @Autowired
    public HelloRemote helloRemote;

    @GetMapping("hello/{name}")
    public String hello(@PathVariable("name") String name){
        System.out.println("消费端返回 name:"+name);
        return helloRemote.hello(name);
    }

}
