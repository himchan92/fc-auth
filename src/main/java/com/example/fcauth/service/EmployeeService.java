package com.example.fcauth.service;

import com.example.fcauth.model.Employee;
import com.example.fcauth.repository.EmployeeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor //스프링 생성자 DI 롬복지원
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> listEmployees(){
        return employeeRepository.findAll(); //JPA 제공
    }

    @Transactional
    public Employee createEmployee(String firstName, String lastName, Long departmentId) {
        Employee employee = Employee.builder()
            .firstName(firstName)
            .lastName(lastName)
            .departmentId(departmentId)
            .build();

        employeeRepository.save(employee);

        return employee;
    }
}
