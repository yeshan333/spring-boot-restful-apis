package com.example.bodymanagement.Repository.Impl;

import com.example.bodymanagement.Repository.InformationRepository;
import com.example.bodymanagement.entity.InformationEntity;

import com.example.bodymanagement.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service("InformationRepository")
public class InformantionRepositoryImpl implements InformationRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    private static Logger logger = LoggerFactory.getLogger(InformantionRepositoryImpl.class);

    @Override
    public List<InformationEntity> findOneAll(String userName) {
        return mongoTemplate.findAll(InformationEntity.class,userName);
    }

    @Override
    public void InsertInfOne(String result,String user_name) {
        mongoTemplate.save(result,user_name);
    }

    @Override
    public void InsertInfMul(InformationEntity informationEntity) {
        //todo
//        mongoTemplate.save(informationEntity,"Data");
    }

    @Override
    public InformationEntity findLatestInf(String user_name) {
        Query query=new Query();
        query.skip(mongoTemplate.count(query,user_name)-1);
        return mongoTemplate.findOne(query,InformationEntity.class,user_name);
    }

    @Override
    public void deleteInfById(String id,String userName) {
        Query query=new Query(Criteria.where("id").regex(id,"i"));
        mongoTemplate.remove(query,InformationEntity.class,userName);
    }

    @Override
    public List<InformationEntity> findselfInfOne(String userName, String DataTime) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        if (userName != null && !userName.equals("")) {
            Pattern patternuserName = Pattern.compile("^.*" + userName + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("user_name").regex(String.valueOf(userName), "i");
        }

        if (DataTime != null && !DataTime.equals("")) {
            Pattern patternDataTime = Pattern.compile("^.*" + DataTime + ".*$", Pattern.CASE_INSENSITIVE);
            criteria.and("student_name").regex(String.valueOf(patternDataTime), "i");
        }
        query.addCriteria(criteria);
        return mongoTemplate.find(query, InformationEntity.class,userName);
    }
}
