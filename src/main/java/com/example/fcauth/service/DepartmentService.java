package com.example.fcauth.service;

import com.example.fcauth.model.Department;
import com.example.fcauth.repository.DepartmentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> listDepartments() {
        return departmentRepository.findAll();
    }
}
