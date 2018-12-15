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
    @ElasticSearchMappingFields
    private String id;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer channel;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer plantform;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer client;
    @ElasticSearchMappingFields
    private String serialNumber;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer orderStatus;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer orderType;
    @ElasticSearchMappingFields
    private String marketId;
    @ElasticSearchMappingFields
    private String shopId;
    @ElasticSearchMappingFields
    private String payableAmount;
    @ElasticSearchMappingFields
    private String createUserId;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "date", index = "not_analyzed")
    })
    private Date createDate;
    @ElasticSearchMappingFields
    private String purchaserId;
    @ElasticSearchMappingFields
    private String receiverMobile;
    @ElasticSearchMappingFields
    private String mobile;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer deleteFlag;
    @ElasticSearchMappingFields
    private Integer referenceId;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer deliverType;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private String deliverStatus;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer canRefund;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "date", index = "not_analyzed")
    })
    private Date agreedDeliveryDate;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "date", index = "not_analyzed")
    })
    private Date realDeliverDate;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "date", index = "not_analyzed")
    })
    private Date realReceivedDate;
    @ElasticSearchMappingFields
    private String provinceId;
    @ElasticSearchMappingFields
    private String cityId;
    @ElasticSearchMappingFields
    private String districtId;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer isStage;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer settlementStatus;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer reviewStatus;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private String refundStatus;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer afterSaleStatus;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer extendStatus;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer extendType;

    //addition
    @ElasticSearchMappingFields
    private String largeRegionId;
    @ElasticSearchMappingFields
    private String smallRegionId;
    @ElasticSearchMappingFields
    private String buildingId;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "integer", index = "not_analyzed")
    })
    private Integer paymentLock;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "string", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "string", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "string", index = "not_analyzed")
    })
    private String shopBrandName;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "string", index = "analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "string", index = "analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "string", index = "analyzed")
    })
    private Date firstPaymentDate;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "date", index = "not_analyzed")
            , @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_JZ, type = "date", index = "not_analyzed")
    })
    private Date lastPaymentDate;

    //customer service
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "string", index = "not_analyzed")
    })
    private String orderId;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "string", index = "not_analyzed")
    })
    private String refundOrderId;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "integer", index = "not_analyzed")
    })
    private String returnGoodsType;
    @ElasticSearchMappingFields({
            @ElasticSearchMappingField(indexName = AbstractElasticSearchService.INDEX_SALES_REFUND, type = "date", index = "not_analyzed")
    })
    private Date lastMerchantConfirmTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getPlantform() {
        return plantform;
    }

    public void setPlantform(Integer plantform) {
        this.plantform = plantform;
    }

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(String payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(Integer deliverType) {
        this.deliverType = deliverType;
    }

    public String getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(String deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    public Integer getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Integer canRefund) {
        this.canRefund = canRefund;
    }

    public Date getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }

    public void setAgreedDeliveryDate(Date agreedDeliveryDate) {
        this.agreedDeliveryDate = agreedDeliveryDate;
    }

    public Date getRealDeliverDate() {
        return realDeliverDate;
    }

    public void setRealDeliverDate(Date realDeliverDate) {
        this.realDeliverDate = realDeliverDate;
    }


    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public Integer getIsStage() {
        return isStage;
    }

    public void setIsStage(Integer isStage) {
        this.isStage = isStage;
    }

    public Integer getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(Integer settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getAfterSaleStatus() {
        return afterSaleStatus;
    }

    public void setAfterSaleStatus(Integer afterSaleStatus) {
        this.afterSaleStatus = afterSaleStatus;
    }

    public Integer getExtendStatus() {
        return extendStatus;
    }

    public void setExtendStatus(Integer extendStatus) {
        this.extendStatus = extendStatus;
    }

    public Integer getExtendType() {
        return extendType;
    }

    public void setExtendType(Integer extendType) {
        this.extendType = extendType;
    }

    public String getLargeRegionId() {
        return largeRegionId;
    }

    public void setLargeRegionId(String largeRegionId) {
        this.largeRegionId = largeRegionId;
    }

    public String getSmallRegionId() {
        return smallRegionId;
    }

    public void setSmallRegionId(String smallRegionId) {
        this.smallRegionId = smallRegionId;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public Integer getPaymentLock() {
        return paymentLock;
    }

    public void setPaymentLock(Integer paymentLock) {
        this.paymentLock = paymentLock;
    }

    public String getShopBrandName() {
        return shopBrandName;
    }

    public void setShopBrandName(String shopBrandName) {
        this.shopBrandName = shopBrandName;
    }

    public Date getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }

    public Date getRealReceivedDate() {
        return realReceivedDate;
    }

    public void setRealReceivedDate(Date realReceivedDate) {
        this.realReceivedDate = realReceivedDate;
    }

    public Date getLastPaymentDate() {
        return lastPaymentDate;
    }

    public void setLastPaymentDate(Date lastPaymentDate) {
        this.lastPaymentDate = lastPaymentDate;
    }

    public Date getLastMerchantConfirmTime() {
        return lastMerchantConfirmTime;
    }

    public void setLastMerchantConfirmTime(Date lastMerchantConfirmTime) {
        this.lastMerchantConfirmTime = lastMerchantConfirmTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public String getReturnGoodsType() {
        return returnGoodsType;
    }

    public void setReturnGoodsType(String returnGoodsType) {
        this.returnGoodsType = returnGoodsType;
    }

}
