package com.mo.demo.web.controller;

import com.mo.demo.common.common.Result;
import com.mo.demo.api.feign.IDemoRemote;
import com.mo.demo.web.feign.IRestDemoRemote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author MoXingwang on 2018/1/27.
 */
@RestController
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private IDemoRemote demoRemote;
    @Autowired
    private IRestDemoRemote restDemoRemote;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/feign/{name}")
    public Result<String> feign(@PathVariable(name = "name")String name) {
        return demoRemote.getString(name);
    }


    @GetMapping(value = "/feign2/{name}")
    public Result<String> feign2(@PathVariable(name = "name")String name) {
        return restDemoRemote.getString(name);
    }

    @GetMapping(value = "/rest/{name}")
    public Result<String> rest(@PathVariable(name = "name")String name) {
        return restTemplate.getForObject("http://demo-service/rest/query/"+name,Result.class);
    }

}
