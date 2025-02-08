package com.example.fcauth.controller;

import com.example.fcauth.model.KakaoUserInfoRespDto;
import com.example.fcauth.repository.EmployeeRepository;
import com.example.fcauth.service.KakaoService;
import com.example.fcauth.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //로깅 롬복 지원
@RestController
@RequiredArgsConstructor
public class KakaoLoginController {
    private final LoginService loginService;
    
    // 카카오 개발가이드에 따라 callback 개발
    @GetMapping("/kakao/callback")
    public ResponseEntity callback(@RequestParam("code") String code) {
        return loginService.login(code);
    }
}
