package com.example.bodymanagement.Repository;

import com.example.bodymanagement.entity.InformationEntity;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface InformationRepository {
    void InsertInfOne(String result);
    void InsertInfMul(InformationEntity informationEntity);
    List<InformationEntity> findLatestInf();
}
