package com.example.bodymanagement.Service;

import com.example.bodymanagement.entity.UserEntity;

import java.util.List;

public interface UserService {
    /**
     * 显示所有用户
     *
     * @return
     */
    List<UserEntity> findAllUser();

    /**
     * 添加用户
     *
     * @param result
     * @return
     */
    String insertone(String result);

    /**
     * 模糊查询用户
     *
     * @param id
     * @param student_code
     * @param student_name
     * @return
     */

    UserEntity findUser(String id, String student_code, String student_name);


    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    String deleteOneUserById(String id);

    /**
     * 批量删除
     *
     * @param id
     * @return
     */
    String deleteMulUserById(String[] id);

    String deleteOneUserByUserName(String username);

    /**
     * 修改用户信息
     *
     * @param userEntity
     * @return
     */
    String UpdateUserById(String result);

    /**
     *
     */
    boolean findOneUser(String user_name, String password);

    /**
     *
     */
    UserEntity findOneUserById(String id);
}
