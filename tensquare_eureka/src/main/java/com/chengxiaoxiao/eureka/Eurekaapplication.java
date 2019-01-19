package com.chengxiaoxiao.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Cheng Xiaoxiao
 */
@SpringBootApplication
@EnableEurekaServer
public class Eurekaapplication {
    public static void main(String[] args) {
        SpringApplication.run(Eurekaapplication.class);
    }
}
