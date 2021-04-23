package com.example.bodymanagement.Service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.bodymanagement.Enum.ResultEnum;
import com.example.bodymanagement.Enum.VO.ResultVO;
import com.example.bodymanagement.Repository.UserReposity;
import com.example.bodymanagement.Service.UserService;
import com.example.bodymanagement.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReposity userReposity;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<UserEntity> findAllUser() {

        return userReposity.findAll();
    }

    @Override
    public String insertone(String result) {

            JSONObject jsonObject = (JSONObject) JSON.parse(result);
//        JSONObject jsonObject = JSONObject.parseObject(json);

            UserEntity userEntity=new UserEntity();

            userEntity.setUser_name(jsonObject.get("user_name").toString());
            userEntity.setPass_word(bCryptPasswordEncoder.encode(jsonObject.get("pass_word").toString()));
            userEntity.setStudent_code(jsonObject.get("student_code").toString());
            userEntity.setStudent_name(jsonObject.get("student_name").toString());
            userEntity.setRole(jsonObject.get("Role").toString());

        return userReposity.insertOne(userEntity);
    }

    /**
     * 模糊查询用户
     * @Author Mu_hui
     * @param id
     * @param student_code
     * @param student_name
     * @return
     */
    @Override

    public UserEntity findUser(String id,String student_code,String student_name) {

        return userReposity.findone(id,student_code,student_name);
    }

    @Override
    public String deleteOneUserById(String id) {
        try {
            userReposity.deleteOneUserById(id);
        }catch (Exception e){
            return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE,false));
        }
        return JSON.toJSONString(ResultVO.result(ResultEnum.SUCCESS,true));
    }

    @Override
    public String deleteMulUserById(String[] id) {
        //todo
        return null;
    }

    @Override
    public String deleteOneUserByUserName(String username) {
        try {
            userReposity.deleteOneUserByUserName(username);
        }catch (Exception e){
            return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE,false));
        }
        return JSON.toJSONString(ResultVO.result(ResultEnum.SUCCESS,true));
    }

    @Override
    public String UpdateUserById(String result) {
        JSONObject jsonResult = (JSONObject) JSON.parse(result);
        String id=(String) jsonResult.get("id");
        UserEntity userEntity=new UserEntity();
        userEntity.setId(id);
        userEntity.setUser_name((String) jsonResult.get("user_name"));
        userEntity.setPass_word(bCryptPasswordEncoder.encode((String) jsonResult.get("pass_word")));
        userEntity.setStudent_code((String) jsonResult.get("student_code"));
        userEntity.setStudent_name((String) jsonResult.get("student_name"));
        userEntity.setRole((String) jsonResult.get("Role"));
        try {
            userReposity.updateUserById(id,userEntity);
        }catch (Exception e){
            return JSON.toJSONString(ResultVO.result(ResultEnum.FAILURE,false));
        }
        return JSON.toJSONString(ResultVO.result(ResultEnum.SUCCESS,true));
    }



    @Override
    public boolean findOneUser(String user_name, String password) {
        return userReposity.findOneUser(user_name,password);
    }

    @Override
    public UserEntity findOneUserById(String id) {
        return userReposity.findOneById(id);
    }


}
