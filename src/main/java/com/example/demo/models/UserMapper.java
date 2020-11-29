package com.example.demo.models;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Results({
        @Result(property = "name", column = "name"),
        @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM User")
    List<User> findAll();

    /* CRUD */

    @Select("SELECT * FROM User WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO User(name, age) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    @Update("UPDATE User SET age=#{age} WHERE name=#{name}")
    void update(User user);

    @Delete("DELETE FROM User WHERE id =#{id}")
    void delete(Long id);
}