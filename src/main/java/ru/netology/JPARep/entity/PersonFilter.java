package ru.netology.JPARep.entity;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public record PersonFilter(String name, String surname, String age, String city) {
    public Specification<Person> toSpecification() {
        return Specification.where(nameSpec())
                .and(surnameSpec())
                .and(ageSpec())
                .and(citySpec());
    }

    private Specification<Person> nameSpec() {
        return ((root, query, cb) -> StringUtils.hasText(name)
                ? cb.equal(root.get("name"), name)
                : null);
    }

    private Specification<Person> surnameSpec() {
        return ((root, query, cb) -> StringUtils.hasText(surname)
                ? cb.equal(root.get("surname"), surname)
                : null);
    }

    private Specification<Person> ageSpec() {
        return ((root, query, cb) -> StringUtils.hasText(age)
                ? cb.equal(root.get("age"), age)
                : null);
    }

    private Specification<Person> citySpec() {
        return ((root, query, cb) -> StringUtils.hasText(city)
                ? cb.equal(root.get("city"), city)
                : null);
    }
}