package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Person;

public interface PersonService {

    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     */
    int create(String name, Integer age);

    /**
     * 根据 name 查询用户
     *
     * @param name
     * @return
     */
    List<Person> getByName(String name);

    /**
     * 根据name删除用户
     *
     * @param name
     */
    int deleteByName(String name);


    /**
     * 根据名字更改用户信息
     *
     * @param name
     */
    int updateByName(String name, Person person);


    /**
     * 获取用户总量
     */
    int getAllPersons();

    /**
     * 删除所有用户
     */
    int deleteAllPersons();

}