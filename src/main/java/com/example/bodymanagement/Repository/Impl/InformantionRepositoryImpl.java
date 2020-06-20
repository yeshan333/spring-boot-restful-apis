package com.example.bodymanagement.Repository.Impl;

import com.alibaba.fastjson.util.TypeUtils;
import com.example.bodymanagement.Repository.InformationRepository;
import com.example.bodymanagement.entity.InformationEntity;
import com.example.bodymanagement.entity.UserEntity;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.internal.MongoClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;

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
    public List<InformationEntity> findLatestInf() {
        Query query=new Query();
        Query query1=new Query(Criteria.where("id"));
        Criteria criteria=new Criteria();
        System.out.println(mongoTemplate.count(query,"Data"));
//        query.with(Sort.by(Order.desc("id")));
        query.skip(mongoTemplate.count(query,"Data")-1);


        return mongoTemplate.find(query,InformationEntity.class);
    }
}
