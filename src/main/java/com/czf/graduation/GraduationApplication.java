package com.czf.graduation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.czf.graduation.mapper")
public class GraduationApplication {
    public static void main(String[] args) {
        SpringApplication.run(GraduationApplication.class, args);
    }
}
