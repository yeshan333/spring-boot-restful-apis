package com.example.demo.services.impl;

import java.util.List;

import com.example.demo.models.Person;
import com.example.demo.services.PersonService;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    private JdbcTemplate jdbcTemplate;

    PersonServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int create(String name, Integer age) {
        return jdbcTemplate.update("insert into Person(NAME, AGE) values(?, ?)", name, age);
    }

    @Override
    public List<Person> getByName(String name) {
        List<Person> Persons = jdbcTemplate.query("select NAME, AGE from Person where NAME = ?", (resultSet, i) -> {
            Person Person = new Person();
            Person.setName(resultSet.getString("NAME"));
            Person.setAge(resultSet.getInt("AGE"));
            return Person;
        }, name);
        return Persons;
    }

    @Override
    public int deleteByName(String name) {
        return jdbcTemplate.update("delete from Person where NAME = ?", name);
    }

    @Override
    public int updateByName(String name, Person person) {
        return jdbcTemplate.update("update Person set NAME = ?, AGE = ? where NAME = ?", person.getName(), person.getAge(), name);
    }

    @Override
    public int getAllPersons() {
        return jdbcTemplate.queryForObject("select count(1) from Person", Integer.class);
    }

    @Override
    public int deleteAllPersons() {
        return jdbcTemplate.update("delete from Person");
    }

}
