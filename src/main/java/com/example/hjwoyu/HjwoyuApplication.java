package com.example.hjwoyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class HjwoyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(HjwoyuApplication.class, args);
    }

}
