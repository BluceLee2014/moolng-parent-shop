package com.moolng.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MoolngMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoolngMQApplication.class, args);
    }

}
