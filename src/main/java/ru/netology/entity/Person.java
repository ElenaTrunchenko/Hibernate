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
    @Id
    @Column(nullable = false, length = 100)
    private String name;

    @Id
    @Column(nullable = false, length = 200)
    private String surname;

    @Id
    @Column(nullable = false)
    private Integer age;

    @Column(length = 50)
    private String phoneNumber;

    @Column(length = 168)
    private String city_of_living;

}
