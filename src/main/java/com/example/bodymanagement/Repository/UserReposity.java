package com.example.bodymanagement.Repository;

import com.example.bodymanagement.entity.UserEntity;


import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserReposity {
     List<UserEntity> findAll();


    UserEntity findone(String id, String student_code, String student_name);

    // BUG: MongoDB ObjectID 删除有问题
    void deleteOneUserById(String id);

    void deleteMulUserById(String[] id);

    void deleteOneUserByUserName(String username);

    boolean findOneUser(String user_name,String pass_word);

    UserEntity findOneById(String id);

    boolean findOneByUserName(String User_name);

    String insertOne(UserEntity result);

    void updateUserById(String id,UserEntity userEntity);
}
