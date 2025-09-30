package com.example.fcauth.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .components(new Components())
            .info(apiInfo());
    }

    //스웨거 문서 타이틀 설정
    private Info apiInfo() {
        return new Info()
            .title("FastCampus 인증 프로젝트")
            .description("Spring doc를 사용한 FC auth Swagger UI")
            .version("1.0.0");
    }
}
