package top.moxingwang.elasticsearch.listener;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.Acknowledgment;
import top.moxingwang.elasticsearch.dto.DebeziumEvent;
import top.moxingwang.elasticsearch.service.AbstractElasticSearchService;
import top.moxingwang.elasticsearch.service.ElasticSearchService;

import java.util.List;

/**
 * @description:
 * @author: MoXingwang 2018-11-29 21:39
 * <p>
 **/
public class KafkaListener {
    private static Logger logger = LoggerFactory.getLogger(KafkaListener.class);

    @Autowired
    private ElasticSearchService elasticSearchService;

    @org.springframework.kafka.annotation.KafkaListener(topics = {
            AbstractElasticSearchService.SERVER_DB + AbstractElasticSearchService.POINT + AbstractElasticSearchService.TABLE_TX_ORDER,
            AbstractElasticSearchService.SERVER_DB + AbstractElasticSearchService.POINT + AbstractElasticSearchService.TABLE_TX_ORDER_ADDITION,
            AbstractElasticSearchService.SERVER_DB + AbstractElasticSearchService.POINT + AbstractElasticSearchService.TABLE_TX_CUSTOMER_SERVICE,
    })
    public void listner(List<ConsumerRecord<Object, DebeziumEvent>> crs, Acknowledgment acknowledgment) {

        for (ConsumerRecord<Object, DebeziumEvent> cr : crs) {
            DebeziumEvent debeziumEvent = cr.value();
            try {
                logger.info("debezium数据事件{}", JSON.toJSONString(debeziumEvent.getPayload().getAfter()));
                elasticSearchService.index(cr.topic(), debeziumEvent.getPayload().getBefore(), debeziumEvent.getPayload().getAfter());
            } catch (Exception e) {
                logger.error("debezium数据事件处理异常{}", cr.toString(), e);

                continue;
            }
        }
        acknowledgment.acknowledge();
    }

}
