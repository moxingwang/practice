package top.moxingwang.elasticsearch.controller;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.moxingwang.elasticsearch.service.AbstractElasticSearchService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TransportClient client;

    @GetMapping(value = "/list")
    public List<String> listJson() {
        List<String> stringList = new ArrayList<>();
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery()
//                    .must(QueryBuilders.matchQuery("serialNumber", "SO4463590000012482"))
//                .must(QueryBuilders.matchQuery("marketId", "1119"))
//                .must(QueryBuilders.termsQuery("extendType", "0", "1", "4"))
//                .must(QueryBuilders.termQuery("afterSaleStatus", "0"))
//                .must(QueryBuilders.termQuery("deleteFlag", "0"))
//                    .must(QueryBuilders.wildcardQuery("serialNumber", "*SO5046240000014238*"))
//                .must(QueryBuilders.matchQuery("serialNumber", "SO5046240000014238"))
//                    .must(QueryBuilders.matchQuery("serialNumber", "*57*"))

//                .must(QueryBuilders.termsQuery("orderStatus", "7","1","15", "3", "18", "14", "17", "23"))
//                .must(QueryBuilders.termsQuery("extendType", "0", "1", "4"))
//                    .must(queryBuilderExtendType)//和上面等价
//                .must(QueryBuilders.termQuery("afterSaleStatus", "0"))
//                    .must(QueryBuilders.termQuery("deleteFlag", false))
                ;

//            queryBuilder.filter(QueryBuilders.rangeQuery("realDeliverDate").from("113684767000"));


        SearchResponse response = client.prepareSearch(AbstractElasticSearchService.INDEX_SALES).setTypes(AbstractElasticSearchService.INDEX_TYPE).setSearchType(SearchType.DEFAULT)

                .setQuery(queryBuilder)
//                    .setQuery(QueryBuilders.termQuery("orderType", "1"))
//                    .setQuery(QueryBuilders.termQuery("serialNumber", "sale_order2016083000000305"))
//                    .setQuery(QueryBuilders.termsQuery("orderStatus", "1", "15", "7", "14", "19"))
//                    .setPostFilter(QueryBuilders.rangeQuery("paidAmount").from("0").to("1000000"))
//                .setFrom(0).setSize(3)//设置数量
//                    .addSort(SortBuilders.fieldSort("orderType").order(SortOrder.ASC))
                // Tip：若我们设置了addFields()方法，但是并没有采用hit.getFields()方式，而直接使用hit.getSource()或hit.getSourceAsString()方法获取数据，所有的数据将会是null。 [http://blog.51cto.com/zh9526/1770531]
//                    .addFields(new String[]{"id", "lastUpdateDate", "orderType", "dealerName", "payableAmount", "cityName", "serialNumber", "createDate","agreedDeliveryDate"})

                .get();

        Long total = response.getHits().getTotalHits();
        System.out.println("总数" + total);
        for (SearchHit searchHit : response.getHits()) {
            String jsonStr = searchHit.getSourceAsString();
            stringList.add(jsonStr);
        }

        return stringList;
    }

}
