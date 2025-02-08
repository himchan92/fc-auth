package com.example.fcauth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // key 생성을 auto increment 설정
    private Long id;

    private String firstName;

    private String lastName;

    private Long departmentId;
}
