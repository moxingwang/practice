package com.mo.demo.service.controller;

import com.mo.demo.common.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MoXingwang on 2018/1/27.
 */
@RestController
@RequestMapping(value = "rest")
public class RestDemoController {

    @GetMapping(value = "/query/{name}")
    public Result<String> query(@PathVariable(name = "name")String name) {
        return Result.success(name);
    }
}
