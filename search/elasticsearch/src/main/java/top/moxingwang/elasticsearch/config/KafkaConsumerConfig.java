package top.moxingwang.elasticsearch.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.OffsetResetStrategy;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import top.moxingwang.elasticsearch.dto.DebeziumEvent;
import top.moxingwang.elasticsearch.listener.KafkaListener;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.springframework.kafka.listener.AbstractMessageListenerContainer.AckMode.MANUAL;

/**
 * https://blog.csdn.net/russle/article/details/80296006
 *
 * @description:
 * @author: MoXingwang 2018-11-29 21:36
 **/
@Configuration
@EnableKafka
public class KafkaConsumerConfig {
    private String servers="localhost:9092";
    private String groupId = "orders";

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, DebeziumEvent>> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, DebeziumEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(MANUAL);
        factory.setBatchListener(true);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, DebeziumEvent> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(DebeziumEvent.class,fooObjectMapper()));
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "100");
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, OffsetResetStrategy.EARLIEST.toString().toLowerCase(Locale.ROOT));
        return propsMap;
    }

    @Bean
    public ObjectMapper fooObjectMapper() {
        ObjectMapper map = new ObjectMapper();
        map.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return map;
    }

    @Bean
    KafkaListener listener() {
        return new KafkaListener();
    }
}
