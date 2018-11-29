package top.moxingwang.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;

/**
 * @description:
 * @author: MoXingwang 2018-11-28 20:21
 **/
@Configuration
public class ElasticSearchConfig {
    private RestHighLevelClient client;

    @Bean
    public RestHighLevelClient elasticsearchRestHighLevelClient() {
        client = new RestHighLevelClient(
                RestClient.builder(
//                        new HttpHost("esuc.dev.rs.com", 9200, "http")
                        new HttpHost("localhost", 9200, "http")
                ));

        return client;
    }

    @PreDestroy
    public void destroy() {
        try {
            if (null != client) {
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
