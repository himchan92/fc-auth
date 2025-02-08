package com.example.fcauth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class KakaoLoginUIController {
    @Value("${kakao.client_id}") // application.properties
    private String clientId;

    @Value("${kakao.redirect_uri}")
    private String redirectUri;

    @GetMapping("/page")
    public String loginPage(Model model) {
        //카카오 로그인 띄우는 위치 설정
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=" + clientId + "&redirect_uri=" + redirectUri;

        // 뷰단으로 데이터 전달
        model.addAttribute("location", location);

        return "login";
    }
}
