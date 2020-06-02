package com.moolng.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MoolngEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoolngEurekaApplication.class, args);
    }

}
