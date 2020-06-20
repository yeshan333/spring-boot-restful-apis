package com.example.bodymanagement.Service;

import com.example.bodymanagement.entity.UserEntity;

import java.util.List;

public interface UserService {
   List<UserEntity> findAllUser();

   String  insertone(UserEntity userEntity1);

    /**
     * 模糊查询用户
     * @param id
     * @param student_code
     * @param student_name
     * @return
     */
    List<UserEntity> findUser(String  id,String student_code,String student_name);

    /**
     * 删除用户
     * @param id
     * @return
     */
    String deleteOneUserById(String id);

    String deleteMulUserById(String[] id);
}
