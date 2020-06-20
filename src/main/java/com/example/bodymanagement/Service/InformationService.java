package com.example.bodymanagement.Service;

import com.example.bodymanagement.entity.InformationEntity;
import com.example.bodymanagement.entity.UserEntity;

import java.util.List;

public interface InformationService {
    void insertInfOne(String result);
    void insertInfMul(InformationEntity informationEntity);
    List<InformationEntity> findLatestInf();
}
