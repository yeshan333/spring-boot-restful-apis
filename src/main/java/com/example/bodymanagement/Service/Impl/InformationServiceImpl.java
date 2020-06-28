package com.example.bodymanagement.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.bodymanagement.Enum.ResultEnum;
import com.example.bodymanagement.Enum.VO.ResultVO;
import com.example.bodymanagement.Repository.InformationRepository;
import com.example.bodymanagement.Repository.UserReposity;
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
    @Autowired
    private UserReposity userReposity;

    @Override
    public String insertInfOne(String result, String user_name) {
        if (!userReposity.findOneByUserName(user_name) ) {
            return JSON.toJSONString(ResultVO.result(ResultEnum.USER_NO_EXIST, false));
        }
        try {
            informationRepository.InsertInfOne(result,user_name);
        } catch (Exception e) {
            return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE, false));
        }
        return JSON.toJSONString(ResultVO.result(ResultEnum.SUCCESS, true));
    }

    @Override
    public String findOneAll(String userName) {
       if(informationRepository.findOneAll(userName )==null){
           return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE, false));
       }else {
           return JSON.toJSONString(informationRepository.findOneAll(userName));
       }
    }

    @Override
    public void insertInfMul(InformationEntity informationEntity) {
        //todo
    }

    @Override
    public String findLatestInf(String user_name) {
        if(informationRepository.findLatestInf(user_name)==null){
            return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE, false));
        }
        return JSON.toJSONString(informationRepository.findLatestInf(user_name));
    }

    @Override
    public String deleteInfByid(String id,String userName) {
      try {
          informationRepository.deleteInfById(id,userName);
      }catch (Exception e){
          return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE, false));
      }
        return JSON.toJSONString(ResultVO.result(ResultEnum.SUCCESS, true));
    }

    @Override
    public String findselfInfOne(String userName, String DataTime) {
        if(informationRepository.findselfInfOne(userName,DataTime)==null){
            return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE, false));
        }
        return JSON.toJSONString(informationRepository.findselfInfOne(userName,DataTime));
    }
}
