package com.example.fcauth.controller;

import com.example.fcauth.model.Department;
import com.example.fcauth.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Basics", description = "기본 관리 API") //스웨거 설정된 것으로 패키지화
public class DepartmentController {

    private final DepartmentService departmentService;

    @Operation(description = "전사 부서 조회") //스웨거 API 코멘트
    @GetMapping("/departments")
    public ResponseEntity<List<Department>> listDepartments() {
        return new ResponseEntity<>(departmentService.listDepartments(), HttpStatus.OK);
    }
}