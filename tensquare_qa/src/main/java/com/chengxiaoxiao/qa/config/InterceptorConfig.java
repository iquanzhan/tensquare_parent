package com.chengxiaoxiao.qa.config;

import com.chengxiaoxiao.qa.interceptor.JwtIntercptor;

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
    public JwtIntercptor jwtIntercptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login/**");
    }
}
