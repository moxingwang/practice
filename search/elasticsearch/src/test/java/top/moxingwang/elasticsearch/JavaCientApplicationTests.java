package top.moxingwang.elasticsearch;

import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaCientApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private RestHighLevelClient restHighLevelClient;

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
