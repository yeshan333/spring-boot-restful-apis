package com.example.bodymanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Document(collection = "User_collection")
@Data
//用户实体类
public class UserEntity implements Serializable {
    //用户账号
    //主键
    @Id
    private String id;      // * 没做自增 * 随便用了UUID凑合
    //登录账号
    private String user_name;
    //账号密码
    private String pass_word;
    //学生学号
    private String student_code;
    //学生姓名
    private String student_name;
    //账号权限
    /**
     * 角色权限控制
     * Role_ADMIN 管理员权限
     * Role_USER 用户权限
     */
    private String Role;
}
