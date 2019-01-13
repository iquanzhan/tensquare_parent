package com.chengxiaoxiao.user.config;

import com.chengxiaoxiao.user.intercptor.JwtIntercptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Cheng Xiaoxiao
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtIntercptor jwtIntercptor;
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
