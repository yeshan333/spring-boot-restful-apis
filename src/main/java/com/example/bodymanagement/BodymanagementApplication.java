package com.example.bodymanagement;

import com.alibaba.fastjson.util.TypeUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BodymanagementApplication {

    public static void main(String[] args) {

        TypeUtils.compatibleWithJavaBean =true;
        SpringApplication.run(BodymanagementApplication.class, args);
    }

}
