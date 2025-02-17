package com.example.fcauth.service;

import com.example.fcauth.model.Employee;
import com.example.fcauth.repository.EmployeeRepository;
import java.util.DuplicateFormatFlagsException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //final 대상 DI 지원
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> listEmpoyees() {
        return employeeRepository.findAll(); //전체 조회 JPA 메소드
    }

    //직원등록
    public Employee createEmployee(String firstName, String lastName, Long departmentId, String kakaoNickName) {
        if(employeeRepository.existsByKakaoNickName(kakaoNickName)) {
            throw new DuplicateKeyException("같은 카카오 닉네임이 존재합니다");
        }

        //빌더패턴 : 생성자 비슷하게 가독성있게 롬복에서 지원
        Employee employee = Employee.builder()
            .firstName(firstName)
            .lastName(lastName)
            .departmentId(departmentId)
            .kakaoNickName(kakaoNickName)
            .build();
        employeeRepository.save(employee);

        return employee;
    }
}
