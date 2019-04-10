package com.chengxiaoxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName: Application
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-04-10
 */
@EnableZuulProxy
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
