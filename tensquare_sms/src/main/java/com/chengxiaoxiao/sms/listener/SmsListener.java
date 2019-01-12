package com.chengxiaoxiao.sms.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Cheng Xiaoxiao
 */
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @RabbitHandler
    public void executeSms(Map<String,String> map){
        System.out.printf("手机号码："+map.get("mobile"));
        System.out.printf("验证码："+map.get("code"));
    }
}
