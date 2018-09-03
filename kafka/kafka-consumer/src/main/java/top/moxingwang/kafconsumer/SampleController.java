package top.moxingwang.kafconsumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            template.send("dbserver1.inventory.orders", "testKey  ", data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        template.send("tx_order.tx_order.test", "testKey  ", data);
        return "success";
    }
}