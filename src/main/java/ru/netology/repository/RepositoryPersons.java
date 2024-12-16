package ru.netology.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.entity.Person;

import java.util.List;

@Repository
public class RepositoryPersons {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        return entityManager.createQuery("from Person where city = UPPER(:city)", Person.class)
                .setParameter("city", city)
                .getResultList();
    }

}
