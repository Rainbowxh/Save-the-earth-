package com.example.finalpaper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(value = "com.example.finalpaper.Mapper")
@SpringBootApplication
public class FinalpaperApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalpaperApplication.class, args);
    }

}

