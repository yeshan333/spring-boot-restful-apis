package com.example.bodymanagement.Repository.Impl;

import com.example.bodymanagement.Repository.InformationRepository;
import com.example.bodymanagement.entity.InformationEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service("InformationRepository")
public class InformantionRepositoryImpl implements InformationRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public void InsertInfOne(String result) {

        Query query=new Query();
        mongoTemplate.save(result,"Data");
    }

    @Override
    public void InsertInfMul(InformationEntity informationEntity) {
        mongoTemplate.save(informationEntity,"Data");
    }

    @Override
    public InformationEntity findLatestInf() {
        Query query=new Query();
        Query query1=new Query(Criteria.where("id"));
        Criteria criteria=new Criteria();
        System.out.println(mongoTemplate.count(query,"Data"));
//        query.with(Sort.by(Order.desc("id")));
        query.skip(mongoTemplate.count(query,"Data")-1);


        return mongoTemplate.findOne(query,InformationEntity.class);
    }
}
