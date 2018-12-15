package top.moxingwang.elasticsearch.es;


import top.moxingwang.elasticsearch.es.annotation.ElasticSearchMappingField;
import top.moxingwang.elasticsearch.es.annotation.ElasticSearchMappingFields;
import top.moxingwang.elasticsearch.service.AbstractElasticSearchService;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: MoXingwang 2018-12-11 15:37
 **/
public class ElasticSearchIndex implements Serializable {
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES)
    })
    private String orderNumber;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES)
    })
    private Date orderDate;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "date")
    })
    private String purchaser;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES)
    })
    private String purchaserName;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES)
    })
    private String quantity;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES)
    })
    private String productId;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "date")
    })
    private Date createDate;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPurchaser() {
        return purchaser;
    }

    public void setPurchaser(String purchaser) {
        this.purchaser = purchaser;
    }

    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
