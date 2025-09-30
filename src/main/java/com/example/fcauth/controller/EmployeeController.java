package com.example.fcauth.controller;

import com.example.fcauth.model.Employee;
import com.example.fcauth.service.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Basics", description = "기본 관리 API") //스웨거 설정된 것으로 패키지화
public class EmployeeController {

    private final EmployeeService employeeService;

    //status ok 응답 양식 포함 json 형식 결과
    //produces는 필수작성은 아님
    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> listAll() {
        return new ResponseEntity<>(employeeService.listEmployees(), HttpStatus.OK);
    }

    //신규사원등록
    @PostMapping("employees")
    public ResponseEntity<Employee> create(@RequestParam String firstName, //디폴트 필수입력
                                           @RequestParam String lastName,
                                           @RequestParam Long departmentId) {
        Employee newEmployee = employeeService.createEmployee(firstName, lastName, departmentId);

        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }
}