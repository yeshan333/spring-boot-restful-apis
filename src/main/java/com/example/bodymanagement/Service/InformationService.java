package com.example.bodymanagement.Service;

import com.example.bodymanagement.entity.InformationEntity;
import com.example.bodymanagement.entity.UserEntity;

import java.util.List;

public interface InformationService {
    /**
     * 插入一条数据
     * @param result
     */
    String insertInfOne(String result,String user_name);

    /**
     * 查询所有数据
     * @return
     */
    String findOneAll(String userName);

    /**
     * 插入多组数据
     * @param informationEntity
     */
    void insertInfMul(InformationEntity informationEntity);

    /**
     * 查询最新的插入的信息
     * @return
     */
    String findLatestInf(String user_name);

    /**
     * 删除某条记录
     * @param id
     */
    String deleteInfByid(String id,String userName);

    String findselfInfOne(String userName,String DataTime);
}
