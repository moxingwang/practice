package top.moxingwang.kafconsumer;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @description: 纯java client kafka消费者
 * @author: MoXingwang 2018-08-05 13:14
 */
public class MyKafkaConsumerWithoutSpring extends Thread {

    public static void main(String[] args) {
        new MyKafkaConsumerWithoutSpring().start();
    }

    public void run() {
        Properties props = new Properties();

        String topic = "dbserver1.inventory.customers";

        props.put("bootstrap.servers", "192.168.226.184:9092,192.168.226.27:9092,192.168.226.189:9092");
        props.put("group.id", "myGroupId");

        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("serializer.encoding", "UTF-8");

        //选择正确的序列化方式
        props.put("key.deserializer", KafkaAvroDeserializer.class.getName());
        props.put("value.deserializer", KafkaAvroDeserializer.class.getName());
        props.put("schema.registry.url", "http://localhost:8081");


        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);


        consumer.subscribe(Arrays.asList(topic));
        System.out.println("Subscribed to topic " + topic);
        int i = 0;

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("offset = %d, key = %s, value = %s\n",
                        record.offset(), record.key(), record.value());
        }

    }


}
