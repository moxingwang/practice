package top.moxingwang.elasticsearch.es.annotation;

import top.moxingwang.elasticsearch.service.AbstractElasticSearchService;

import java.lang.annotation.*;

/**
 * @description:
 * @author: MoXingwang 2018-12-11 17:27
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface ElasticSearchMappingFields {

    ElasticSearchMappingField[] value() default {
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "string", index = "not_analyzed")
    };

}
