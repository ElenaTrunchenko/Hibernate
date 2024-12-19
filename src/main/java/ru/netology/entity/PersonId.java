package ru.netology.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
