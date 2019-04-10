package com.chengxiaoxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @ClassName: ConfigServerApplication
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-04-10
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class);
    }
}
