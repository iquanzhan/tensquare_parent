package com.chengxiaoxiao.spit.controller;

import com.chengxiaoxiao.spit.dao.SpitDao;
import com.chengxiaoxiao.spit.pojo.Spit;
import com.chengxiaoxiao.spit.service.SpitService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: SpitController
 * @description:
 * @author: Cheng XiaoXiao  (🍊 ^_^ ^_^)
 * @Date: 2019-01-09
 */
@RestController
@CrossOrigin
@RequestMapping("/spit")
public class SpitController {

    @Autowired
    private SpitService spitService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findAll());
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.GET)
    public Result findOne(@PathVariable String spitId) {
        return new Result(true, StatusCode.OK, "查询成功", spitService.findById(spitId));
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "spitId") String spitId, @RequestBody Spit spit) {
        spit.set_id(spitId);
        spitService.update(spit);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Spit spit) {
        spitService.add(spit);
        return new Result(true, StatusCode.OK, "新增成功");
    }

    @RequestMapping(value = "/{spitId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String spitId) {
        spitService.deleteById(spitId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value = "/comment/{parentid}/{page}/{size}", method = RequestMethod.GET)
    public Result fingByParentId(@PathVariable String parentid, @PathVariable int page, @PathVariable int size) {
        Page<Spit> pages = spitService.findByParentId(parentid, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Spit>(pages.getTotalElements(), pages.getContent()));
    }
}
