package com.mo.demo.service.controller;

import com.mo.demo.common.common.Result;
import com.mo.demo.api.feign.IDemoRemote;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MoXingwang on 2018/1/27.
 */
@RestController
public class FeignDemoController implements IDemoRemote {

    @Override
    public Result<String> getString(@PathVariable(name = "name")String name) {

        return new Result<String>(200,"成功",name);
    }
}
