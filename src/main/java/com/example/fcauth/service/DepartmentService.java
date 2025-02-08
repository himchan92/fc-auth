package com.example.fcauth.service;

import com.example.fcauth.model.Department;
import com.example.fcauth.model.Employee;
import com.example.fcauth.repository.DepartMentRepository;
import com.example.fcauth.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //final 대상 DI 지원
public class DepartmentService {
    private final DepartMentRepository departMentRepository;

    public List<Department> listDepartments() {
        return departMentRepository.findAll(); //전체 조회 JPA 메소드
    }
}
