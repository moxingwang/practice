package top.moxingwang.elasticsearch;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * -----------  rest client 方式访问    -------------
     */

    /**
     * 创建index
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest();
        createIndexRequest.index("trade-order-order");
        CreateIndexResponse indicesClient = restHighLevelClient.indices().create(createIndexRequest,RequestOptions.DEFAULT);

        System.out.println(indicesClient);
    }

    @Test
    public void createDocument() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("user", "kimchy");
            builder.timeField("postDate", new Date());
            builder.field("message", "trying out Elasticsearch");
        }
        builder.endObject();
        IndexRequest indexRequest = new IndexRequest("trade-order-order", "doc").source(builder);

        restHighLevelClient.index(indexRequest,RequestOptions.DEFAULT);

        System.out.println(indexRequest);
    }

    /**
     * 分页查询
     * @throws IOException
     */
    @Test
    public void query() throws IOException {
        SearchRequest searchRequest = new SearchRequest("trade-order-order");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("name", ""));
        sourceBuilder.from(0);
        sourceBuilder.size(5);
        searchRequest.source(sourceBuilder);

        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);

        System.out.println(response.getHits());
        System.out.println(1);
    }


    /**
     * -----------  spring boot java client 方式访问    -------------
     */
    @Test
    public void contextLoads() {
        IndexQuery indexQuery = new IndexQueryBuilder().withObject(new User("111", "111")).build();
        elasticsearchTemplate.index(indexQuery);

    }

    @Document(indexName = "test", type = "test")
    class User {
        private String user;
        private String id;

        public User(String user, String id) {
            this.user = user;
            this.id = id;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
