package com.mo.dubbo.provider.service;

import com.mo.dubbo.api.IOrderTestService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: MoXingwang 2018-08-28 20:17
 **/
@Service
public class OrderTestService implements IOrderTestService {
    @Override
    public String getOrder() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
