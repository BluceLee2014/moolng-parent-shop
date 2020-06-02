package com.moolng.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan({"com.moolng.**.mapper"})
//@EnableDiscoveryClient
//@EnableEurekaClient
@SpringBootApplication
public class MoolngOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoolngOrderApplication.class, args);
    }
}
