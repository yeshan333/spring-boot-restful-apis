package com.example.bodymanagement.Repository.Impl;

import com.example.bodymanagement.Repository.UserReposity;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@Service("UserReposity")
public class UserRepositoryImpl implements UserReposity {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserEntity> findAll() {
        return mongoTemplate.findAll(UserEntity.class);
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
}
