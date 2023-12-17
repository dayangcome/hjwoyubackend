package com.example.hjwoyu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置，不可设置为*，不安全, 前后端分离项目，可能域名不一致
        //本地测试 端口不一致 也算跨域
        registry.addMapping("/**")
                .allowedOrigins("http://www.huaijinwoyu.fun","http://huaijinwoyu.fun","47.236.95.98:8080","http://localhost:8080")
                .allowCredentials(true)
                .allowedMethods("GET","POST")
                .allowedOriginPatterns("*")
                .maxAge(3600)
        ;
    }
}
