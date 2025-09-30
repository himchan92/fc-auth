package com.example.fcauth.controller;

import com.example.fcauth.model.Employee;
import com.example.fcauth.service.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    //status ok 응답 양식 포함 json 형식 결과
    //produces는 필수작성은 아님
    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> listAll() {
        return new ResponseEntity<>(employeeService.listEmployees(), HttpStatus.OK);
    }
}
