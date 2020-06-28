package com.example.bodymanagement.Repository.Impl;

import com.alibaba.fastjson.JSON;
import com.example.bodymanagement.Enum.ResultEnum;
import com.example.bodymanagement.Enum.VO.ResultVO;
import com.example.bodymanagement.Repository.UserReposity;
import com.example.bodymanagement.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@Service("UserReposity")
public class UserRepositoryImpl implements UserReposity {
//    private static Logger logger = LoggerFactory.getLogger(InformantionRepositoryImpl.class);
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserEntity> findAll() {
        return mongoTemplate.findAll(UserEntity.class,"User_collection");
    }

    @Override
    public List<UserEntity> findone(String id, String student_code, String student_name) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        if (id != null && !id.equals("")) {
            Pattern patternId = Pattern.compile("^.*" + id + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("id").regex(String.valueOf(patternId), "i");
        }
        if (student_code != null && !student_code.equals("")) {
            Pattern patternstudentCode = Pattern.compile("^.*" + student_code + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("student_code").regex(String.valueOf(patternstudentCode), "i");
        }
        if (student_name != null && !student_name.equals("")) {
            Pattern patternstudentName = Pattern.compile("^.*" + student_name + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("student_name").regex(String.valueOf(patternstudentName), "i");
        }
        query.addCriteria(criteria);
        return mongoTemplate.find(query, UserEntity.class);
    }

    @Override
    public void deleteOneUserById(String id) {
        Query query = new Query(Criteria.where("id").regex(id, "i"));
        mongoTemplate.remove(query, UserEntity.class);
    }

    @Override
    public void deleteMulUserById(String[] id) {
        Query query = new Query();
        for (String ids : id
        ) {
            query.addCriteria(Criteria.where("id").regex(ids,"i"));
            mongoTemplate.remove(query,UserEntity.class);
        }
    }

    @Override
    public boolean findOneUser(String user_name, String pass_word) {
        Query query=new Query();
        Criteria criteria=new Criteria();
        Criteria criteriaA=new Criteria();
        Criteria criteriaB=new Criteria();
        criteriaA.and("id").regex(user_name);
        criteriaB.and("pass_word").regex(pass_word);
        criteria.andOperator(criteriaA,criteriaB);
        query.addCriteria(criteria);
        if (mongoTemplate.findOne(query,UserEntity.class,"User_collection")!=null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public UserEntity findOneById(String id) {
        Query query=new Query(Criteria.where("user_name").regex(id));
        return mongoTemplate.findOne(query,UserEntity.class,"User_collection");
    }

    @Override
    public boolean findOneByUserName(String User_name) {
        Query query=new Query(Criteria.where("user_name").regex(User_name));
        if(mongoTemplate.findOne(query,UserEntity.class,"User_collection")==null){
            return false;
        }
        return true;
    }

    @Override
    public String  insertOne(UserEntity result) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.and("user_name").regex(result.getUser_name());
        query.addCriteria(criteria);
        if (mongoTemplate.findOne(query, UserEntity.class, "User_collection") == null) {
            mongoTemplate.save(result, "User_collection");
           return JSON.toJSONString(ResultVO.result(ResultEnum.SUCCESS,true));
        }else {
            return JSON.toJSONString(ResultVO.result(ResultEnum.LOGIN_IS_EXIST,false));
        }
    }

    @Override
    public void updateUserById(String id, UserEntity userEntity) {
        Query query=new Query(Criteria.where("id").regex(id));
        Update update=new Update();
        update.set("pass_word",userEntity.getPass_word());
        update.set("student_name",userEntity.getStudent_name());
        update.set("student_code",userEntity.getStudent_code());
        update.set("Role",userEntity.getRole());
        mongoTemplate.updateFirst(query,update,"User_collection");
    }
}
