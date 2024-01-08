package com.example.hjwoyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * <p>
 * 启动类
 * </p>
 *
 * @author 大洋
 * @since 2023-11-28
 */
@SpringBootApplication
@ServletComponentScan
public class HjwoyuApplication {

    public static void main(String[] args) {
        SpringApplication.run(HjwoyuApplication.class, args);
    }

}
