package com.example.bodymanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_collection")
@Data
//用户实体类
public class UserEntity {
    //用户账号
    //主键
    @Id
    private String id;
    //账号密码
    private String pass_word;
    //学生学号
    private String student_code;
    //学生姓名
    private String student_name;
    //账号权限
    private String auth;
}
