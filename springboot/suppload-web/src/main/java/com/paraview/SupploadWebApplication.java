package com.paraview;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan({"com.paraview.mapper","com.paraview.oracleMapper"})
@EnableSwagger2
public class SupploadWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupploadWebApplication.class, args);
    }

}
