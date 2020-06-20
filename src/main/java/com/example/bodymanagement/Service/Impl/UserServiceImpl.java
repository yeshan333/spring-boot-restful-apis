package com.example.bodymanagement.Service.Impl;

import com.example.bodymanagement.Repository.UserReposity;
import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReposity userReposity;



    @Override
    public List<UserEntity> findAllUser() {

        return userReposity.findAll();
    }

    @Override
    public String insertone(UserEntity userEntity1) {
        try {
//            userReposity.insert(userEntity1);
            return "success";
        } catch (Exception e) {
            return "error";
        }

    }

    /**
     * 模糊查询用户
     * @Author Mu_hui
     * @param id
     * @param student_code
     * @param student_name
     * @return
     */
    @Override
    public List<UserEntity> findUser(String id,String student_code,String student_name) {
        return userReposity.findone(id,student_code,student_name);
    }

    @Override
    public String deleteOneUserById(String id) {
        try {
            userReposity.deleteOneUserById(id);
            return "success";
        }catch (Exception e){
            return "error";
        }
    }

    @Override
    public String deleteMulUserById(String[] id) {
        return null;
    }
}
