package top.moxingwang.elasticsearch.dto;

import java.io.Serializable;

/**
 * @description:
 * @author: MoXingwang 2018-11-30 18:55
 **/
public class DebeziumEvent implements Serializable {
    private DebeziumEventPayload payload;

    public DebeziumEventPayload getPayload() {
        return payload;
    }

    public void setPayload(DebeziumEventPayload payload) {
        this.payload = payload;
    }
}
