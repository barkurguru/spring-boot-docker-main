package com.docker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String country;
}
