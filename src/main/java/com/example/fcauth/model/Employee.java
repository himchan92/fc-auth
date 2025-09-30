package com.example.fcauth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity //컬럼과 테이블 매핑해서 DB 테이블생성
@Getter
public class Employee {

    @Id //PK설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENT
    private Long id;

    private String firstName;

    private String lastName;

    private Long departmentId;
}
