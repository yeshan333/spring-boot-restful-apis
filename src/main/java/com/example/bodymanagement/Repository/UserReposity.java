package com.example.bodymanagement.Repository;

import com.example.bodymanagement.entity.UserEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserReposity{
     List<UserEntity> findAll();

    List<UserEntity> findone(String id,String student_code,String student_name);

    void deleteOneUserById(String id);

    void deleteMulUserById(String[] id);
}
