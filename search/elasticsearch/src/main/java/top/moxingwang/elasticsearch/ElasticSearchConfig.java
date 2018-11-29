package top.moxingwang.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: MoXingwang 2018-11-28 20:21
 **/
@Configuration
public class ElasticSearchConfig {
    @Bean
    public RestHighLevelClient elasticsearchRestHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("esuc.dev.rs.com", 9200, "http")));

        return client;
    }


    /**
     * todo client.close();
     */

}
