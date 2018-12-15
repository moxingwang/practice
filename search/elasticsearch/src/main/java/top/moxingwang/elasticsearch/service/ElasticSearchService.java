package top.moxingwang.elasticsearch.service;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.moxingwang.elasticsearch.es.ElasticSearchIndex;
import top.moxingwang.elasticsearch.es.annotation.ElasticSearchMappingField;
import top.moxingwang.elasticsearch.es.annotation.ElasticSearchMappingFields;
import top.moxingwang.elasticsearch.util.StringNameParseUtil;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: MoXingwang 2018-12-06 17:49
 **/
@Service
public class ElasticSearchService extends AbstractElasticSearchService {
    private static Logger logger = LoggerFactory.getLogger(ElasticSearchService.class);

    @Autowired
    private TransportClient transportClient;

    @Override
    public void index(String topic, ElasticSearchIndex beforeTable, ElasticSearchIndex afterTable) {
        //数据处理

        String indexName = INDEX_SALES;

        String afterJson = JSON.toJSONString(afterTable);
        String beforeJson = JSON.toJSONString(beforeTable);
        if (afterJson.equals(beforeJson)) {
            logger.info("未获取到更新{},{},{}", topic, afterJson, beforeJson);
            return;
        } else {
            logger.info("更新数据{}", afterJson);
        }

        IndexRequest indexRequest = new IndexRequest(indexName, INDEX_TYPE, afterTable.getId())
                .source(afterJson);
        UpdateRequest updateRequest = new UpdateRequest(indexName, INDEX_TYPE, afterTable.getId())
                .doc(afterJson)
                .upsert(indexRequest);
        ActionFuture<UpdateResponse> updateResponseActionFuture = transportClient.update(updateRequest);
    }


    @PostConstruct
    public void init() {
        Field[] fields = ElasticSearchIndex.class.getDeclaredFields();
        for (Field field : fields) {
            boolean fieldHasAnno = field.isAnnotationPresent(ElasticSearchMappingFields.class);
            if (fieldHasAnno) {
                ElasticSearchMappingFields elasticSearchMappingFields = field.getAnnotation(ElasticSearchMappingFields.class);
                for (ElasticSearchMappingField elasticSearchMappingField : elasticSearchMappingFields.value()) {
                    List<String> list = INDEX_FIELDS_TEMPLATE.get(elasticSearchMappingField.indexName());
                    if (null == list) {
                        list = new ArrayList<>();
                        INDEX_FIELDS_TEMPLATE.put(elasticSearchMappingField.indexName(), list);
                    }
                    list.add(StringNameParseUtil.camelToUnderline(field.getName()));
                }
            }
        }

    }

}
