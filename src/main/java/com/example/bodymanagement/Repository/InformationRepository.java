package com.example.bodymanagement.Repository;

import com.example.bodymanagement.entity.InformationEntity;
import org.springframework.stereotype.Component;

@Component
public interface InformationRepository {
    void InsertInfOne(String result);
    void InsertInfMul(InformationEntity informationEntity);
    InformationEntity findLatestInf();
}
