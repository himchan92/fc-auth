package com.example.fcauth.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;

@Entity
@Getter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "123", description = "auto increment pk") //스웨거 코멘트
    private Long id;

    @Schema(example = "인사팀", description = "부서 이름") //스웨거 코멘트
    private String deptName;

    @Schema(example = "123456", description = "담당 조직장 임직원 ID") //스웨거 코멘트
    @OneToOne
    @JoinColumn(name = "team_lead_id", referencedColumnName = "id") //연관맺으려면 누구랑 할건지 매핑시켜줘야함
    private Employee teamLead;
}
