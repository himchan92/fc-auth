package com.example.fcauth.service;

import com.example.fcauth.model.KakaoUserInfoRespDto;
import com.example.fcauth.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final KakaoService kakaoService;
    private final EmployeeRepository employeeRepository;

    public ResponseEntity login(String code) {
        String token = kakaoService.getAccessTokenFromKakao(code);
        KakaoUserInfoRespDto dto = kakaoService.getUserFromKakao(token);
        String nickName = dto.getKakaoAccount().getProfile().getNickName();
        if(employeeRepository.existsByKakaoNickName(nickName)) {
            return new ResponseEntity("환영합니다 " + nickName, HttpStatus.OK);
        } else {
            return new ResponseEntity("등록된 임직원이 아닙니다.", HttpStatus.OK);
        }
    }
}
