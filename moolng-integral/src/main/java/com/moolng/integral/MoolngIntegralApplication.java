package com.moolng.integral;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan({"com.moolng.**.mapper"})
@EnableDiscoveryClient
@SpringBootApplication
public class MoolngIntegralApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoolngIntegralApplication.class, args);
    }


}
