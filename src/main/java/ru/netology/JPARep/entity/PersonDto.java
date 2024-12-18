package ru.netology.JPARep.entity;

import lombok.Value;

/**
 * DTO for {@link Person}
 */
@Value
public class PersonDto {
    String name;
    String surname;
    Integer age;
    String city;
    Integer phone_number;
}