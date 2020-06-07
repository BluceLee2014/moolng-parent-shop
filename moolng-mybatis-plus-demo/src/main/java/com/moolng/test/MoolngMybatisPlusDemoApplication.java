package com.moolng.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"com.moolng.**.mapper"})
@SpringBootApplication()
public class MoolngMybatisPlusDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoolngMybatisPlusDemoApplication.class, args);
    }
}
