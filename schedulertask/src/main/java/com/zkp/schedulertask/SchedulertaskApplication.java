package com.zkp.schedulertask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedulertaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulertaskApplication.class, args);
    }

}
