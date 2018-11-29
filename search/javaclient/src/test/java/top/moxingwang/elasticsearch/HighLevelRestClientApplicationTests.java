/*
package top.moxingwang.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;

*/
/**
 * 高版本
 *//*

public class HighLevelRestClientApplicationTests {

    private RestHighLevelClient restHighLevelClient;
    RestClient restClient;

    String index = "trade-order-orders2";

    @Before
    public void elasticsearchRestHighLevelClient() {
        restClient = RestClient.builder(
                new HttpHost("esuc.dev.rs.com", 9200, "http")
//                new HttpHost("esuc.dev.rs.com", 9201, "http")
        ).build();

        restHighLevelClient =
                new RestHighLevelClient(restClient);


    }

    @After
    public void destroy() {
        try {
            if (null != restClient) {
                restClient.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    */
/**
     * 创建index
     *
     * @throws IOException
     *//*

    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest();
        createIndexRequest.index(index);

        IndexRequest indexRequest = new IndexRequest("t1");
        restHighLevelClient.
        restHighLevelClient.index(indexRequest);

    }

    //https://www.elastic.co/guide/en/elasticsearch/client/java-rest/master/java-rest-high-document-index.html
    @Test
    public void createDocument() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("user", "kimchy");
//            builder.timeField("postDate", new Date());
            builder.field("message", UUID.randomUUID().toString());
        }
        builder.endObject();
        IndexRequest indexRequest = new IndexRequest(index, "data").source(builder);


        restHighLevelClient.index(indexRequest);

        System.out.println(indexRequest);
    }

    */
/**
     * 分页查询
     *
     * @throws IOException
     *//*

    @Test
    public void query() throws IOException {
        SearchRequest searchRequest = new SearchRequest(index);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("user", ""));
        sourceBuilder.from(0);
        sourceBuilder.size(5);
        searchRequest.source(sourceBuilder);

//        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//
//        System.out.println(response.getHits());
//        System.out.println(1);
    }


}
*/
