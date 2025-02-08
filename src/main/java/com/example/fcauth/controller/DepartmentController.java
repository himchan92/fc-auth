package com.example.fcauth.controller;

import com.example.fcauth.model.Department;
import com.example.fcauth.repository.DepartMentRepository;
import com.example.fcauth.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Basics", description = "기본 관리 API") // SWAGGER 에서 같은 그룹 조회되게 설정
public class DepartmentController {
    private final DepartmentService departmentService;

    @Operation(description = "전사 부서 조회")
    @GetMapping(value = "/departments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Department>> listAll() {
        return new ResponseEntity<>(departmentService.listDepartments(), HttpStatus.OK);
    }
}
