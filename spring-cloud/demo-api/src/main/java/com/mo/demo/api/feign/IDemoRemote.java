package com.mo.demo.api.feign;

import com.mo.demo.common.common.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author MoXingwang on 2018/1/27.
 */
@FeignClient(value = "demo-service")
public interface IDemoRemote {

    @RequestMapping(value = "/feign/{name}",method = RequestMethod.GET)
    Result<String> getString(@PathVariable(name = "name")String name);
}
