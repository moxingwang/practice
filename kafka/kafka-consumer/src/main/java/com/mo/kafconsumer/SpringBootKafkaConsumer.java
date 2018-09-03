package com.mo.kafconsumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: MoXingwang 2018-07-29 20:58
 **/
@Component
public class SpringBootKafkaConsumer {
    public static Logger logger = LoggerFactory.getLogger(SpringBootKafkaConsumer.class);

    @Autowired
    private KafkaTemplate<String, Object> template;

    @KafkaListener(id = "t31", topics = "dbserver1.inventory.customers")
    public void listenT3(ConsumerRecord<Object, Object> cr) throws Exception {
        logger.info(cr.toString());
    }

//    @KafkaListener(id = "t31141", topics = "rrr.inventory.customers")
    public void listenT34(ConsumerRecord<Object, Object> cr) throws Exception {
        logger.info(cr.toString());
    }
}