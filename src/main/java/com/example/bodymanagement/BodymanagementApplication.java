package com.example.bodymanagement;

import com.alibaba.fastjson.util.TypeUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BodymanagementApplication {

    public static void main(String[] args) {

        TypeUtils.compatibleWithJavaBean =true;
        SpringApplication.run(BodymanagementApplication.class, args);
    }

}
