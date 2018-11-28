package top.moxingwang.elasticsearch;

import org.elasticsearch.client.Client;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * @description:
 * @author: MoXingwang 2018-11-28 20:21
 **/
@Configuration
public class ElasticSearchConfig {
    /*@Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) {
        return new ElasticsearchTemplate(client);
    }*/
}
