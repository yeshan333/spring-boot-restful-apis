package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.Person;
import com.example.demo.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
    @Autowired
    private PersonService persons;

    @GetMapping("/nums")
    public int getPersonNums() {
        return persons.getAllPersons();
    }

    /**
     * localhost:33333/persons?name=Tom
     * @param name
     * @return
     */
    @GetMapping
    public List<Person> getPersonByName(@RequestParam(name = "name") String name) {
        return persons.getByName(name);
    }

    @PostMapping
    public String addPerson(@RequestBody Person person) {
        persons.create(person.getName(), person.getAge());
        return "success";
    }

    @PutMapping
    public String updatePerson(@RequestBody Person person) {
        persons.updateByName(person.getName(), person);
        return "success";
    }

    @DeleteMapping
    public String deletePerson(@RequestBody Person person) {
        persons.deleteByName(person.getName());
        return "success";
    }
}

