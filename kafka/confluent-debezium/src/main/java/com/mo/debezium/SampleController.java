package com.mo.debezium;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @description:
 * @author: MoXingwang 2018-07-29 20:58
 **/
@RestController
public class SampleController {
    public static Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private KafkaTemplate<String, Object> template;

    @RequestMapping(value = "/send/{data}", method = RequestMethod.GET)
    String send(@PathVariable(value = "data") String data) {
        try {
            String s = new String(data.getBytes(), "unicode");
            String ss = new String(s.getBytes(), "unicode");
            String sss = new String(s.getBytes(), "utf8");
            template.send("tx_order.tx_order.test", "testKey  ", s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        template.send("tx_order.tx_order.test", "testKey  ", data);
        return "success";
    }
}