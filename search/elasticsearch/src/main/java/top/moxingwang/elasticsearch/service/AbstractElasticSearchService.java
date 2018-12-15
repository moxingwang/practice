package top.moxingwang.elasticsearch.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.moxingwang.elasticsearch.es.ElasticSearchIndex;
import top.moxingwang.elasticsearch.es.annotation.ElasticSearchMappingField;
import top.moxingwang.elasticsearch.es.annotation.ElasticSearchMappingFields;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: MoXingwang 2018-12-06 17:35
 **/
public abstract class AbstractElasticSearchService {
    private static Logger logger = LoggerFactory.getLogger(AbstractElasticSearchService.class);

    public abstract void index(String topic, ElasticSearchIndex beforeTable, ElasticSearchIndex afterTable) throws JsonProcessingException;

    public static final String INDEX_TYPE = "type";

    public static final String SERVER_DB = "trade_order_0.inventory";

    public static final String INDEX_SALES = "trade-order-sales";


    public static final String POINT = ".";

    public static final String TABLE_TX_ORDER = "orders";

    public static final Map<String, List<String>> INDEX_FIELDS_TEMPLATE = new ConcurrentHashMap<>();

    /**
     * 生成mapping内容
     * @param args
     */
    public static void main(String[] args) {
        Map<String, Map<String, Map<String, String>>> indexMapping = new HashMap<>();
        Field[] fields = ElasticSearchIndex.class.getDeclaredFields();
        for (Field field : fields) {
            boolean fieldHasAnno = field.isAnnotationPresent(ElasticSearchMappingFields.class);
            if (fieldHasAnno) {
                ElasticSearchMappingFields elasticSearchMappingFields = field.getAnnotation(ElasticSearchMappingFields.class);
                for (ElasticSearchMappingField elasticSearchMappingField : elasticSearchMappingFields.value()) {
                    Map<String, Map<String, String>> mapping = indexMapping.get(elasticSearchMappingField.indexName());
                    if (null == mapping) {
                        mapping = new HashMap<>();
                    }
                    indexMapping.put(elasticSearchMappingField.indexName(), mapping);

                    Map<String, String> typeIndex = mapping.get(field.getName());
                    if (null == typeIndex) {
                        typeIndex = new HashMap<>();
                    }
                    mapping.put(field.getName(), typeIndex);

                    typeIndex.put("type", elasticSearchMappingField.type());
//                    typeIndex.put("index", elasticSearchMappingField.index());
                }
            }
        }

        for (Map.Entry<String, Map<String, Map<String, String>>> stringMapEntry : indexMapping.entrySet()) {
            System.out.println(stringMapEntry.getKey() + " mapping映射:" + JSON.toJSONString(stringMapEntry.getValue()));
        }
    }

}
