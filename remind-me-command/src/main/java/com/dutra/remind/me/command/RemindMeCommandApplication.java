package com.dutra.remind.me.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RemindMeCommandApplication {

    public static void main(String args[]) {
        SpringApplication.run(RemindMeCommandApplication.class, args);
    }

}
