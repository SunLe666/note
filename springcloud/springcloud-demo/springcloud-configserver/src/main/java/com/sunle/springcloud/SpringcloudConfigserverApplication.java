package com.sunle.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudConfigserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigserverApplication.class, args);
    }

}
