package com.example.fcauth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;
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

    //중복허용 안되는 고유권한설정이니 Set
    @ManyToMany
    @JoinTable( //ManyToMany는 JoinTable
        name = "employee_role_mapping", //대상테이블
        joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"), //매핑컬럼정보
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id") //추가 매핑컬럼정보
    )
    private Set<Role> roles;
}
