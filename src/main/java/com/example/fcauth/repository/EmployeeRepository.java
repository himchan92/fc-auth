package com.example.fcauth.repository;

import com.example.fcauth.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// 기본 CRUD Method 제공 <연동대상 모델, PK>
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Boolean existsByKakaoNickName(String kakaoNickName);
}
