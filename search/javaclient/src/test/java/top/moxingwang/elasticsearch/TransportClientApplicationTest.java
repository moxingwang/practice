package top.moxingwang.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class TransportClientApplicationTest {
    private TransportClient client;

    String index = "trade-order-orders2";

    @Before
    public void elasticsearchRestHighLevelClient() throws UnknownHostException {
        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch").build();
        client = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("esuc.dev.rs.com"), 9300)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("esuc.dev.rs.com"), 9300)
                );

// on shutdown


//        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("esuc.dev.rs.com"), 9300));
//        System.out.println(1);
        GetResponse response = client.prepareGet("trade-order-orders2", "data", "AWdeq7vLqHbFY58w-GxL").get();

        System.out.println(1);
    }

    @After
    public void destroy() {
        try {
            if (null != client) {
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test() {
//        client.admin().indices().create()
    }

}
