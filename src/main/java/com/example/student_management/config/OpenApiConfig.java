package com.example.student_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI studentApiDocs() {
        return new OpenAPI().info(new Info()
            .title("Student Management API")
            .description("A small student-management REST API built in the Spring Boot crash course")
            .version("1.0"));
    }
}
