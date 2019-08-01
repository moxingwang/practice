package top.moxingwang.springbootfeature.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @description:
 * @author: MoXingwang 2019-08-01 13:59
 **/
@Entity
@Table(name = "tx_order", schema = "tx_order", catalog = "")
public class TxOrderEntity {
    private long id;
    private Long channel;
    private Long plantform;
    private Long client;
    private String serialNumber;
    private Integer orderStatus;
    private Integer orderType;
    private String marketId;
    private String marketName;
    private String shopId;
    private String shopName;
    private BigDecimal totalAmount;
    private BigDecimal promotionTotalAmount;
    private BigDecimal exceptedChangeAmount;
    private BigDecimal deductionTotalAmount;
    private BigDecimal payableAmount;
    private BigDecimal serviceAmount;
    private BigDecimal paidAmount;
    private BigDecimal refundedAmount;
    private String createUserId;
    private String createUserName;
    private Timestamp createDate;
    private String lastUpdateUserId;
    private String lastUpdateUserName;
    private Timestamp lastUpdateDate;
    private Long areaId;
    private String areaName;
    private String purchaserId;
    private String purchaserName;
    private String receiverId;
    private String receiverName;
    private String receiverMobile;
    private String mobile;
    private String address;
    private BigDecimal carriage;
    private String remark;
    private Byte deleteFlag;
    private Long referenceId;
    private Integer deliverType;
    private Integer deliverStatus;
    private Byte canRefund;
    private String contractNumber;
    private String serialCode;
    private String serialName;
    private BigDecimal firstPayment;
    private Timestamp agreedDeliveryDate;
    private String dealerId;
    private String dealerName;
    private Timestamp realDeliverDate;
    private Timestamp realReceivedDate;
    private String provinceId;
    private String provinceName;
    private String cityId;
    private String cityName;
    private String districtId;
    private String districtName;
    private byte isStage;
    private Integer settlementStatus;
    private Timestamp settlementDate;
    private BigDecimal settlementAmount;
    private Timestamp planedSettlementDate;
    private Integer reviewStatus;
    private Integer refundStatus;
    private int afterSaleStatus;
    private String omsUuid;
    private Timestamp reviewDate;
    private String reviewId;
    private String returnVisitStatus;
    private byte extendStatus;
    private Byte extendType;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "channel", nullable = true)
    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    @Basic
    @Column(name = "plantform", nullable = true)
    public Long getPlantform() {
        return plantform;
    }

    public void setPlantform(Long plantform) {
        this.plantform = plantform;
    }

    @Basic
    @Column(name = "client", nullable = true)
    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    @Basic
    @Column(name = "serial_number", nullable = false, length = 255)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Basic
    @Column(name = "order_status", nullable = true)
    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Basic
    @Column(name = "order_type", nullable = true)
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Basic
    @Column(name = "market_id", nullable = true, length = 10)
    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    @Basic
    @Column(name = "market_name", nullable = true, length = 255)
    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    @Basic
    @Column(name = "shop_id", nullable = true, length = 50)
    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    @Basic
    @Column(name = "shop_name", nullable = true, length = 100)
    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Basic
    @Column(name = "total_amount", nullable = true, precision = 2)
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    @Column(name = "promotion_total_amount", nullable = true, precision = 2)
    public BigDecimal getPromotionTotalAmount() {
        return promotionTotalAmount;
    }

    public void setPromotionTotalAmount(BigDecimal promotionTotalAmount) {
        this.promotionTotalAmount = promotionTotalAmount;
    }

    @Basic
    @Column(name = "excepted_change_amount", nullable = true, precision = 2)
    public BigDecimal getExceptedChangeAmount() {
        return exceptedChangeAmount;
    }

    public void setExceptedChangeAmount(BigDecimal exceptedChangeAmount) {
        this.exceptedChangeAmount = exceptedChangeAmount;
    }

    @Basic
    @Column(name = "deduction_total_amount", nullable = false, precision = 2)
    public BigDecimal getDeductionTotalAmount() {
        return deductionTotalAmount;
    }

    public void setDeductionTotalAmount(BigDecimal deductionTotalAmount) {
        this.deductionTotalAmount = deductionTotalAmount;
    }

    @Basic
    @Column(name = "payable_amount", nullable = true, precision = 2)
    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    @Basic
    @Column(name = "service_amount", nullable = true, precision = 2)
    public BigDecimal getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(BigDecimal serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    @Basic
    @Column(name = "paid_amount", nullable = true, precision = 2)
    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    @Basic
    @Column(name = "refunded_amount", nullable = true, precision = 2)
    public BigDecimal getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(BigDecimal refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    @Basic
    @Column(name = "create_user_id", nullable = true, length = 255)
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "create_user_name", nullable = true, length = 255)
    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "last_update_user_id", nullable = true, length = 255)
    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId;
    }

    @Basic
    @Column(name = "last_update_user_name", nullable = true, length = 255)
    public String getLastUpdateUserName() {
        return lastUpdateUserName;
    }

    public void setLastUpdateUserName(String lastUpdateUserName) {
        this.lastUpdateUserName = lastUpdateUserName;
    }

    @Basic
    @Column(name = "last_update_date", nullable = true)
    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Basic
    @Column(name = "area_id", nullable = true)
    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Basic
    @Column(name = "area_name", nullable = true, length = 255)
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    @Basic
    @Column(name = "purchaser_id", nullable = true, length = 255)
    public String getPurchaserId() {
        return purchaserId;
    }

    public void setPurchaserId(String purchaserId) {
        this.purchaserId = purchaserId;
    }

    @Basic
    @Column(name = "purchaser_name", nullable = true, length = 255)
    public String getPurchaserName() {
        return purchaserName;
    }

    public void setPurchaserName(String purchaserName) {
        this.purchaserName = purchaserName;
    }

    @Basic
    @Column(name = "receiver_id", nullable = true, length = 255)
    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId;
    }

    @Basic
    @Column(name = "receiver_name", nullable = true, length = 255)
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    @Basic
    @Column(name = "receiver_mobile", nullable = true, length = 255)
    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 255)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "carriage", nullable = true, precision = 2)
    public BigDecimal getCarriage() {
        return carriage;
    }

    public void setCarriage(BigDecimal carriage) {
        this.carriage = carriage;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 500)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "delete_flag", nullable = true)
    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "reference_id", nullable = true)
    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    @Basic
    @Column(name = "deliver_type", nullable = true)
    public Integer getDeliverType() {
        return deliverType;
    }

    public void setDeliverType(Integer deliverType) {
        this.deliverType = deliverType;
    }

    @Basic
    @Column(name = "deliver_status", nullable = true)
    public Integer getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(Integer deliverStatus) {
        this.deliverStatus = deliverStatus;
    }

    @Basic
    @Column(name = "can_refund", nullable = true)
    public Byte getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Byte canRefund) {
        this.canRefund = canRefund;
    }

    @Basic
    @Column(name = "contract_number", nullable = true, length = 255)
    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    @Basic
    @Column(name = "serial_code", nullable = true, length = 255)
    public String getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(String serialCode) {
        this.serialCode = serialCode;
    }

    @Basic
    @Column(name = "serial_name", nullable = true, length = 255)
    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    @Basic
    @Column(name = "first_payment", nullable = true, precision = 2)
    public BigDecimal getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(BigDecimal firstPayment) {
        this.firstPayment = firstPayment;
    }

    @Basic
    @Column(name = "agreed_delivery_date", nullable = true)
    public Timestamp getAgreedDeliveryDate() {
        return agreedDeliveryDate;
    }

    public void setAgreedDeliveryDate(Timestamp agreedDeliveryDate) {
        this.agreedDeliveryDate = agreedDeliveryDate;
    }

    @Basic
    @Column(name = "dealer_id", nullable = true, length = 255)
    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    @Basic
    @Column(name = "dealer_name", nullable = true, length = 100)
    public String getDealerName() {
        return dealerName;
    }

    public void setDealerName(String dealerName) {
        this.dealerName = dealerName;
    }

    @Basic
    @Column(name = "real_deliver_date", nullable = true)
    public Timestamp getRealDeliverDate() {
        return realDeliverDate;
    }

    public void setRealDeliverDate(Timestamp realDeliverDate) {
        this.realDeliverDate = realDeliverDate;
    }

    @Basic
    @Column(name = "real_received_date", nullable = true)
    public Timestamp getRealReceivedDate() {
        return realReceivedDate;
    }

    public void setRealReceivedDate(Timestamp realReceivedDate) {
        this.realReceivedDate = realReceivedDate;
    }

    @Basic
    @Column(name = "province_id", nullable = true, length = 255)
    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    @Basic
    @Column(name = "province_name", nullable = true, length = 255)
    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    @Basic
    @Column(name = "city_id", nullable = true, length = 255)
    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "city_name", nullable = true, length = 255)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Basic
    @Column(name = "district_id", nullable = true, length = 255)
    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    @Basic
    @Column(name = "district_name", nullable = true, length = 255)
    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    @Basic
    @Column(name = "is_stage", nullable = false)
    public byte getIsStage() {
        return isStage;
    }

    public void setIsStage(byte isStage) {
        this.isStage = isStage;
    }

    @Basic
    @Column(name = "settlement_status", nullable = true)
    public Integer getSettlementStatus() {
        return settlementStatus;
    }

    public void setSettlementStatus(Integer settlementStatus) {
        this.settlementStatus = settlementStatus;
    }

    @Basic
    @Column(name = "settlement_date", nullable = true)
    public Timestamp getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Timestamp settlementDate) {
        this.settlementDate = settlementDate;
    }

    @Basic
    @Column(name = "settlement_amount", nullable = true, precision = 2)
    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    @Basic
    @Column(name = "planed_settlement_date", nullable = true)
    public Timestamp getPlanedSettlementDate() {
        return planedSettlementDate;
    }

    public void setPlanedSettlementDate(Timestamp planedSettlementDate) {
        this.planedSettlementDate = planedSettlementDate;
    }

    @Basic
    @Column(name = "review_status", nullable = true)
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Basic
    @Column(name = "refund_status", nullable = true)
    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    @Basic
    @Column(name = "after_sale_status", nullable = false)
    public int getAfterSaleStatus() {
        return afterSaleStatus;
    }

    public void setAfterSaleStatus(int afterSaleStatus) {
        this.afterSaleStatus = afterSaleStatus;
    }

    @Basic
    @Column(name = "oms_uuid", nullable = true, length = 30)
    public String getOmsUuid() {
        return omsUuid;
    }

    public void setOmsUuid(String omsUuid) {
        this.omsUuid = omsUuid;
    }

    @Basic
    @Column(name = "review_date", nullable = true)
    public Timestamp getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Timestamp reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Basic
    @Column(name = "review_id", nullable = true, length = 50)
    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    @Basic
    @Column(name = "return_visit_status", nullable = true, length = 64)
    public String getReturnVisitStatus() {
        return returnVisitStatus;
    }

    public void setReturnVisitStatus(String returnVisitStatus) {
        this.returnVisitStatus = returnVisitStatus;
    }

    @Basic
    @Column(name = "extend_status", nullable = false)
    public byte getExtendStatus() {
        return extendStatus;
    }

    public void setExtendStatus(byte extendStatus) {
        this.extendStatus = extendStatus;
    }

    @Basic
    @Column(name = "extend_type", nullable = true)
    public Byte getExtendType() {
        return extendType;
    }

    public void setExtendType(Byte extendType) {
        this.extendType = extendType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxOrderEntity that = (TxOrderEntity) o;
        return id == that.id &&
                isStage == that.isStage &&
                afterSaleStatus == that.afterSaleStatus &&
                extendStatus == that.extendStatus &&
                Objects.equals(channel, that.channel) &&
                Objects.equals(plantform, that.plantform) &&
                Objects.equals(client, that.client) &&
                Objects.equals(serialNumber, that.serialNumber) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(orderType, that.orderType) &&
                Objects.equals(marketId, that.marketId) &&
                Objects.equals(marketName, that.marketName) &&
                Objects.equals(shopId, that.shopId) &&
                Objects.equals(shopName, that.shopName) &&
                Objects.equals(totalAmount, that.totalAmount) &&
                Objects.equals(promotionTotalAmount, that.promotionTotalAmount) &&
                Objects.equals(exceptedChangeAmount, that.exceptedChangeAmount) &&
                Objects.equals(deductionTotalAmount, that.deductionTotalAmount) &&
                Objects.equals(payableAmount, that.payableAmount) &&
                Objects.equals(serviceAmount, that.serviceAmount) &&
                Objects.equals(paidAmount, that.paidAmount) &&
                Objects.equals(refundedAmount, that.refundedAmount) &&
                Objects.equals(createUserId, that.createUserId) &&
                Objects.equals(createUserName, that.createUserName) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(lastUpdateUserId, that.lastUpdateUserId) &&
                Objects.equals(lastUpdateUserName, that.lastUpdateUserName) &&
                Objects.equals(lastUpdateDate, that.lastUpdateDate) &&
                Objects.equals(areaId, that.areaId) &&
                Objects.equals(areaName, that.areaName) &&
                Objects.equals(purchaserId, that.purchaserId) &&
                Objects.equals(purchaserName, that.purchaserName) &&
                Objects.equals(receiverId, that.receiverId) &&
                Objects.equals(receiverName, that.receiverName) &&
                Objects.equals(receiverMobile, that.receiverMobile) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(address, that.address) &&
                Objects.equals(carriage, that.carriage) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(deleteFlag, that.deleteFlag) &&
                Objects.equals(referenceId, that.referenceId) &&
                Objects.equals(deliverType, that.deliverType) &&
                Objects.equals(deliverStatus, that.deliverStatus) &&
                Objects.equals(canRefund, that.canRefund) &&
                Objects.equals(contractNumber, that.contractNumber) &&
                Objects.equals(serialCode, that.serialCode) &&
                Objects.equals(serialName, that.serialName) &&
                Objects.equals(firstPayment, that.firstPayment) &&
                Objects.equals(agreedDeliveryDate, that.agreedDeliveryDate) &&
                Objects.equals(dealerId, that.dealerId) &&
                Objects.equals(dealerName, that.dealerName) &&
                Objects.equals(realDeliverDate, that.realDeliverDate) &&
                Objects.equals(realReceivedDate, that.realReceivedDate) &&
                Objects.equals(provinceId, that.provinceId) &&
                Objects.equals(provinceName, that.provinceName) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(cityName, that.cityName) &&
                Objects.equals(districtId, that.districtId) &&
                Objects.equals(districtName, that.districtName) &&
                Objects.equals(settlementStatus, that.settlementStatus) &&
                Objects.equals(settlementDate, that.settlementDate) &&
                Objects.equals(settlementAmount, that.settlementAmount) &&
                Objects.equals(planedSettlementDate, that.planedSettlementDate) &&
                Objects.equals(reviewStatus, that.reviewStatus) &&
                Objects.equals(refundStatus, that.refundStatus) &&
                Objects.equals(omsUuid, that.omsUuid) &&
                Objects.equals(reviewDate, that.reviewDate) &&
                Objects.equals(reviewId, that.reviewId) &&
                Objects.equals(returnVisitStatus, that.returnVisitStatus) &&
                Objects.equals(extendType, that.extendType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, channel, plantform, client, serialNumber, orderStatus, orderType, marketId, marketName, shopId, shopName, totalAmount, promotionTotalAmount, exceptedChangeAmount, deductionTotalAmount, payableAmount, serviceAmount, paidAmount, refundedAmount, createUserId, createUserName, createDate, lastUpdateUserId, lastUpdateUserName, lastUpdateDate, areaId, areaName, purchaserId, purchaserName, receiverId, receiverName, receiverMobile, mobile, address, carriage, remark, deleteFlag, referenceId, deliverType, deliverStatus, canRefund, contractNumber, serialCode, serialName, firstPayment, agreedDeliveryDate, dealerId, dealerName, realDeliverDate, realReceivedDate, provinceId, provinceName, cityId, cityName, districtId, districtName, isStage, settlementStatus, settlementDate, settlementAmount, planedSettlementDate, reviewStatus, refundStatus, afterSaleStatus, omsUuid, reviewDate, reviewId, returnVisitStatus, extendStatus, extendType);
    }
}
