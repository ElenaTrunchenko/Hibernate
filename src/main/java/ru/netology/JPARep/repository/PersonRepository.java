package ru.netology.JPARep.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.netology.JPARep.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

}