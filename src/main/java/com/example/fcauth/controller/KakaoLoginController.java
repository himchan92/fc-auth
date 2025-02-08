package com.example.fcauth.controller;

import com.example.fcauth.model.KakaoUserInfoRespDto;
import com.example.fcauth.service.KakaoService;
import lombok.RequiredArgsConstructor;
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
    private final KakaoService kakaoService;
    
    // 카카오 개발가이드에 따라 callback 개발
    @GetMapping("/kakao/callback")
    public ResponseEntity callback(@RequestParam("code") String code) {
        String token = kakaoService.getAccessTokenFromKakao(code);
        KakaoUserInfoRespDto dto = kakaoService.getUserFromKakao(token);
        log.info("nickname " + dto.getKakaoAccount().getProfile().getNickName());
        return new ResponseEntity(HttpStatus.OK);
    }
}
