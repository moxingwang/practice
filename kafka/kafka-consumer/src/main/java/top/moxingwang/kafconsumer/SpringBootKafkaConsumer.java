package top.moxingwang.kafconsumer;


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

    @KafkaListener(id = "inventorycustomers", topics = "dbserver3.inventory.customers")
    public void listenT3(ConsumerRecord<Object, Object> cr) throws Exception {
        logger.info(cr.toString());
    }

    @KafkaListener(id = "tb_tx_order", topics = "tradeOrderServer.tx_order.tx_order")
    public void listenT34(ConsumerRecord<Object, Object> cr) throws Exception {
        logger.info(cr.toString());
    }

    @KafkaListener(id = "tx_order_addition", topics = "tradeOrderServer.tx_order.tx_order_addition")
    public void tx_order_addition(ConsumerRecord<Object, Object> cr) throws Exception {
        logger.info(cr.toString());
    }
}