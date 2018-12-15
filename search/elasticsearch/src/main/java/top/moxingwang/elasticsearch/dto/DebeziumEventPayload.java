package top.moxingwang.elasticsearch.dto;


import top.moxingwang.elasticsearch.es.ElasticSearchIndex;

import java.io.Serializable;
import java.util.Map;

/**
 * @description:
 * @author: MoXingwang 2018-11-30 18:55
 **/
public class DebeziumEventPayload implements Serializable {
    private ElasticSearchIndex before;
    private ElasticSearchIndex after;
    private Map<String,Object> source;


    public ElasticSearchIndex getBefore() {
        return before;
    }

    public void setBefore(ElasticSearchIndex before) {
        this.before = before;
    }

    public ElasticSearchIndex getAfter() {
        return after;
    }

    public void setAfter(ElasticSearchIndex after) {
        this.after = after;
    }

    public Map<String, Object> getSource() {
        return source;
    }

    public void setSource(Map<String, Object> source) {
        this.source = source;
    }
}
