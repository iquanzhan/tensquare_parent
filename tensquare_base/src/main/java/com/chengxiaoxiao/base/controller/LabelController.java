package com.chengxiaoxiao.base.controller;

import com.chengxiaoxiao.base.pojo.Label;
import com.chengxiaoxiao.base.service.LabelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entity.Result;
import entity.StatusCode;

/**
 * @author Cheng Xiaoxiao
 */
@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "请求成功", labelService.findAll());
    }

    @RequestMapping(name = "/{labelId}", method = RequestMethod.GET)
    public Result findAll(@PathVariable(name = "labelId") String labelId) {

        return new Result(true, StatusCode.OK, "请求成功", labelService.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label) {
        labelService.save(label);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    @RequestMapping(name = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable(name = "labelId") String labelId, @RequestBody Label label) {
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    @RequestMapping(name = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable(name = "labelId") String labelId) {
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

}
