package ru.netology.controller;

import ru.netology.repository.RepositoryPersons;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.netology.entity.Person;


import java.util.List;

@RestController
@RequestMapping("/")
public class controller {
    private RepositoryPersons repository;


    @GetMapping("/persons/by-city")
    public List<Person> getCity(@RequestParam("city") String city) {
        List<Person> result = repository.getPersonsByCity(city);
        System.out.println(result);
        return result;
    }
}

