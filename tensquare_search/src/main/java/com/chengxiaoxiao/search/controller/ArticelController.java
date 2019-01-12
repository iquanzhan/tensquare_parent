package com.chengxiaoxiao.search.controller;

import com.chengxiaoxiao.search.pojo.Articel;
import com.chengxiaoxiao.search.service.ArticelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.PageResult;
import entity.Result;
import entity.StatusCode;

/**
 * @author Cheng Xiaoxiao
 */
@RestController
@CrossOrigin
@RequestMapping("articel")
public class ArticelController {

    @Autowired
    ArticelService articelService;

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Articel articel) {
        articelService.add(articel);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/search/{keyword}/{page}/{size}")
    public Result search(@PathVariable String keyword, @PathVariable int page, @PathVariable int size) {

        Page<Articel> pageArticel = articelService.findByTitleOrContentLike(keyword, page, size);

        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Articel>(pageArticel.getTotalElements(), pageArticel.getContent()));
    }

}
