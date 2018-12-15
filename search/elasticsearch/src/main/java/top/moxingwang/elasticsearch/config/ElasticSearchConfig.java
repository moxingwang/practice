package top.moxingwang.elasticsearch.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: MoXingwang 2018-11-28 20:21
 **/
@Configuration
public class ElasticSearchConfig {
    private static Logger logger = LoggerFactory.getLogger(ElasticSearchConfig.class);

    private String name = "elasticsearch";

    private TransportClient client;

    @Bean
    public TransportClient transportClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", name)
                .put("client.transport.sniff", true)
                .build();

        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        return client;
    }

    @PreDestroy
    public void destroy() {
        try {
            if (null != client) {
                client.close();
            }
        } catch (Exception e) {
            logger.error("客户端关闭异常", e);
        }
    }
}
