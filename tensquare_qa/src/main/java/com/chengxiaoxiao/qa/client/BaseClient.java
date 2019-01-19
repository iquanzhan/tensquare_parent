package com.chengxiaoxiao.qa.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Result;

/**
 * @author Cheng Xiaoxiao
 */
@FeignClient("tensquare-base")
public interface BaseClient {
    @RequestMapping(value = "/label/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId);
}
