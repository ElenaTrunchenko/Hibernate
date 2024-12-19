package ru.netology.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PERSONS")
public class Person {
    @EmbeddedId
    private PersonId personId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 200)
    private String surname;

    @Column(nullable = false)
    private Integer age;

    @Column(length = 50, name = "phone_number")
    private String phone;

    @Column(length = 168, name = "city_of_living")
    private String city;

}
