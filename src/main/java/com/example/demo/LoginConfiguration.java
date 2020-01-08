package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.util.LoginInterceptor;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

	@Override
    public void addInterceptors(InterceptorRegistry registry) {

        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);

        loginRegistry.addPathPatterns("/**");

        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/index");
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/verifyUser");
        loginRegistry.excludePathPatterns("/member/register");
        loginRegistry.excludePathPatterns("/member/saveMember");
        loginRegistry.excludePathPatterns("/loginout");

        loginRegistry.excludePathPatterns("/css/*.css");
        loginRegistry.excludePathPatterns("/js/*.js");
        loginRegistry.excludePathPatterns("/image/*.png");
    }
}
