package com.example.bodymanagement.Service.Impl;

import com.example.bodymanagement.Repository.InformationRepository;
import com.example.bodymanagement.Service.InformationService;
import com.example.bodymanagement.entity.InformationEntity;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InformationService")
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationRepository informationRepository;
    @Override
    public void insertInfOne(String result) {
        informationRepository.InsertInfOne(result);
    }

    @Override
    public void insertInfMul(InformationEntity informationEntity) {
        informationRepository.InsertInfMul(informationEntity);
    }

    @Override
    public List<InformationEntity> findLatestInf() {
        return informationRepository.findLatestInf();
    }
}
