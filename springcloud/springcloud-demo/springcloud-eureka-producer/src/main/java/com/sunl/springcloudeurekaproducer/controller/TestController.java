package com.sunl.springcloudeurekaproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/hello/{name}")
    public String hello(@PathVariable String name){
        System.out.println("生产端返回 name:"+name);
        return "hello:"+name;
    }
}
