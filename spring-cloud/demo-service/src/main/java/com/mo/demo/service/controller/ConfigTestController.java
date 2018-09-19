package com.mo.demo.service.controller;

import com.mo.demo.common.common.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MoXingwang on 2018/1/27.
 */
@RestController
@RequestMapping(value = "config")
@RefreshScope
public class ConfigTestController {

    @Value("${jdbc.master.url}")
    private String name;

    @GetMapping(value = "")
    public Result<String> query() {
        return Result.success(name);
    }
}
