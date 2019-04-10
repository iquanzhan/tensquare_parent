package com.chengxiaoxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName: WebApplication
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-04-10
 */
@SpringBootApplication
@EnableZuulProxy
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class);
    }
}
