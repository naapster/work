package com.example.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class WorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkApplication.class, args);
    }

}
