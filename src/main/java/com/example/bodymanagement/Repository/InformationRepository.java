package com.example.bodymanagement.Repository;

import com.example.bodymanagement.entity.InformationEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface InformationRepository {
    List<InformationEntity> findOneAll(String userName);
    void InsertInfOne(String result,String user_name);
    void InsertInfMul(InformationEntity informationEntity);
    InformationEntity findLatestInf(String user_name);
    void deleteInfById(String id,String userName);
<<<<<<< HEAD

=======
    List<InformationEntity> Adminfinduser(String user_name);
>>>>>>> 68ad2bd... "修复部分bug"
    List<InformationEntity> findselfInfOne(String userName,String DataTime);
}
