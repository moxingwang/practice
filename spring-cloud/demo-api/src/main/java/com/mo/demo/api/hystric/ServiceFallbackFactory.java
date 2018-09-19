package com.mo.demo.api.hystric;

import com.mo.demo.common.common.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;

/**
 * @author MoXingwang on 2018/1/27.
 */
@Service
public class ServiceFallbackFactory implements FallbackFactory<Result>{

    @Override
    public Result create(Throwable throwable) {
        return new Result(500,"服务异常");
    }
}
