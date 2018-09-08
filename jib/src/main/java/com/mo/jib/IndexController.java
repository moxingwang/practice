package com.mo.jib;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: MoXingwang 2018-07-16 16:47
 **/
@RestController
@RequestMapping("index")
public class IndexController {

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public ResponseEntity<String> test1() {

        return ResponseEntity.ok("api test");
    }


}
