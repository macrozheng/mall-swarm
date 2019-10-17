package com.macro.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MallRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallRegistryApplication.class, args);
    }

}
