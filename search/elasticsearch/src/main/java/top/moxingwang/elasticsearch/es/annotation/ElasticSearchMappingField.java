package top.moxingwang.elasticsearch.es.annotation;


import java.lang.annotation.*;

/**
 * @description: https://www.elastic.co/guide/en/elasticsearch/reference/current/mapping.html
 * @author: MoXingwang 2018-12-11 17:27
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ElasticSearchMappingField {
    String indexName();

    String type() default "text";

//    String index() default "not_analyzed";

}
