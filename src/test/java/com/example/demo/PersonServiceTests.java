package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.example.demo.models.Person;
import com.example.demo.services.PersonService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonServiceTests {
    @Autowired
    private PersonService userSerivce;

    @BeforeEach
    public void setUp() {
        // 准备，清空user表
        userSerivce.deleteAllPersons();
    }

    @Test
    public void test() throws Exception {
        // 插入5个用户
        userSerivce.create("Tom", 10);
        userSerivce.create("Mike", 11);
        userSerivce.create("Didispace", 30);
        userSerivce.create("Oscar", 21);
        userSerivce.create("Linda", 17);

        // 查询名为Oscar的用户，判断年龄是否匹配
        List<Person> userList = userSerivce.getByName("Oscar");
        assertEquals(21, userList.get(0).getAge().intValue());

        // 查数据库，应该有5个用户
        assertEquals(5, userSerivce.getAllPersons());

        // 删除两个用户
        userSerivce.deleteByName("Tom");
        userSerivce.deleteByName("Mike");

        // 查数据库，应该有5个用户
        assertEquals(3, userSerivce.getAllPersons());

    }
}

