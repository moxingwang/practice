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
@Table(name = "tx_order_item", schema = "tx_order", catalog = "")
public class TxOrderItemEntity {
    private long id;
    private long orderId;
    private String merchantId;
    private String merchantName;
    private String productId;
    private String productName;
    private String brandId;
    private String brandName;
    private String imgUrl;
    private Integer orderItemType;
    private String unitId;
    private String unitName;
    private BigDecimal unitPrice;
    private BigDecimal salePrice;
    private BigDecimal paidAmount;
    private BigDecimal shareRate;
    private BigDecimal totalAmount;
    private String inventoryId;
    private BigDecimal quantity;
    private BigDecimal realQuantity;
    private Timestamp createDate;
    private byte deleteFlag;
    private String signedCode;
    private String model;
    private String size;
    private String sizeUnit;
    private BigDecimal discountRate;
    private Byte isBlatantly;
    private String serialCode;
    private String serialName;
    private String description;
    private Byte canRefund;
    private String color;
    private String colorRgb;
    private String omsPriceTagCode;
    private String sku;
    private Byte isService;
    private Long referenceItemId;
    private Integer reviewStatus;
    private Timestamp reviewDate;
    private String reviewId;
    private Byte goodsType;
    private Byte saleChannel;
    private Byte unitIsShow;
    private int packageNumber;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id", nullable = false)
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "merchant_id", nullable = true, length = 255)
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    @Basic
    @Column(name = "merchant_name", nullable = true, length = 255)
    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Basic
    @Column(name = "product_id", nullable = true, length = 255)
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_name", nullable = false, length = 255)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "brand_id", nullable = true, length = 255)
    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "brand_name", nullable = true, length = 255)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "img_url", nullable = true, length = 500)
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "order_item_type", nullable = true)
    public Integer getOrderItemType() {
        return orderItemType;
    }

    public void setOrderItemType(Integer orderItemType) {
        this.orderItemType = orderItemType;
    }

    @Basic
    @Column(name = "unit_id", nullable = true, length = 255)
    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    @Basic
    @Column(name = "unit_name", nullable = true, length = 255)
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Basic
    @Column(name = "unit_price", nullable = false, precision = 2)
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Basic
    @Column(name = "sale_price", nullable = false, precision = 2)
    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
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
    @Column(name = "share_rate", nullable = true, precision = 8)
    public BigDecimal getShareRate() {
        return shareRate;
    }

    public void setShareRate(BigDecimal shareRate) {
        this.shareRate = shareRate;
    }

    @Basic
    @Column(name = "total_amount", nullable = false, precision = 2)
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Basic
    @Column(name = "inventory_id", nullable = true, length = 255)
    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    @Basic
    @Column(name = "quantity", nullable = false, precision = 2)
    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "real_quantity", nullable = false, precision = 2)
    public BigDecimal getRealQuantity() {
        return realQuantity;
    }

    public void setRealQuantity(BigDecimal realQuantity) {
        this.realQuantity = realQuantity;
    }

    @Basic
    @Column(name = "create_date", nullable = false)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "delete_flag", nullable = false)
    public byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "signed_code", nullable = true, length = 255)
    public String getSignedCode() {
        return signedCode;
    }

    public void setSignedCode(String signedCode) {
        this.signedCode = signedCode;
    }

    @Basic
    @Column(name = "model", nullable = true, length = 255)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "size", nullable = true, length = 255)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "size_unit", nullable = true, length = 255)
    public String getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(String sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    @Basic
    @Column(name = "discount_rate", nullable = true, precision = 2)
    public BigDecimal getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(BigDecimal discountRate) {
        this.discountRate = discountRate;
    }

    @Basic
    @Column(name = "is_blatantly", nullable = true)
    public Byte getIsBlatantly() {
        return isBlatantly;
    }

    public void setIsBlatantly(Byte isBlatantly) {
        this.isBlatantly = isBlatantly;
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
    @Column(name = "description", nullable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "color", nullable = true, length = 255)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "color_rgb", nullable = true, length = 255)
    public String getColorRgb() {
        return colorRgb;
    }

    public void setColorRgb(String colorRgb) {
        this.colorRgb = colorRgb;
    }

    @Basic
    @Column(name = "oms_price_tag_code", nullable = true, length = 255)
    public String getOmsPriceTagCode() {
        return omsPriceTagCode;
    }

    public void setOmsPriceTagCode(String omsPriceTagCode) {
        this.omsPriceTagCode = omsPriceTagCode;
    }

    @Basic
    @Column(name = "sku", nullable = true, length = 255)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @Basic
    @Column(name = "is_service", nullable = true)
    public Byte getIsService() {
        return isService;
    }

    public void setIsService(Byte isService) {
        this.isService = isService;
    }

    @Basic
    @Column(name = "reference_item_id", nullable = true)
    public Long getReferenceItemId() {
        return referenceItemId;
    }

    public void setReferenceItemId(Long referenceItemId) {
        this.referenceItemId = referenceItemId;
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
    @Column(name = "goods_type", nullable = true)
    public Byte getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Byte goodsType) {
        this.goodsType = goodsType;
    }

    @Basic
    @Column(name = "sale_channel", nullable = true)
    public Byte getSaleChannel() {
        return saleChannel;
    }

    public void setSaleChannel(Byte saleChannel) {
        this.saleChannel = saleChannel;
    }

    @Basic
    @Column(name = "unit_is_show", nullable = true)
    public Byte getUnitIsShow() {
        return unitIsShow;
    }

    public void setUnitIsShow(Byte unitIsShow) {
        this.unitIsShow = unitIsShow;
    }

    @Basic
    @Column(name = "package_number", nullable = false)
    public int getPackageNumber() {
        return packageNumber;
    }

    public void setPackageNumber(int packageNumber) {
        this.packageNumber = packageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TxOrderItemEntity that = (TxOrderItemEntity) o;
        return id == that.id &&
                orderId == that.orderId &&
                deleteFlag == that.deleteFlag &&
                packageNumber == that.packageNumber &&
                Objects.equals(merchantId, that.merchantId) &&
                Objects.equals(merchantName, that.merchantName) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(brandId, that.brandId) &&
                Objects.equals(brandName, that.brandName) &&
                Objects.equals(imgUrl, that.imgUrl) &&
                Objects.equals(orderItemType, that.orderItemType) &&
                Objects.equals(unitId, that.unitId) &&
                Objects.equals(unitName, that.unitName) &&
                Objects.equals(unitPrice, that.unitPrice) &&
                Objects.equals(salePrice, that.salePrice) &&
                Objects.equals(paidAmount, that.paidAmount) &&
                Objects.equals(shareRate, that.shareRate) &&
                Objects.equals(totalAmount, that.totalAmount) &&
                Objects.equals(inventoryId, that.inventoryId) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(realQuantity, that.realQuantity) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(signedCode, that.signedCode) &&
                Objects.equals(model, that.model) &&
                Objects.equals(size, that.size) &&
                Objects.equals(sizeUnit, that.sizeUnit) &&
                Objects.equals(discountRate, that.discountRate) &&
                Objects.equals(isBlatantly, that.isBlatantly) &&
                Objects.equals(serialCode, that.serialCode) &&
                Objects.equals(serialName, that.serialName) &&
                Objects.equals(description, that.description) &&
                Objects.equals(canRefund, that.canRefund) &&
                Objects.equals(color, that.color) &&
                Objects.equals(colorRgb, that.colorRgb) &&
                Objects.equals(omsPriceTagCode, that.omsPriceTagCode) &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(isService, that.isService) &&
                Objects.equals(referenceItemId, that.referenceItemId) &&
                Objects.equals(reviewStatus, that.reviewStatus) &&
                Objects.equals(reviewDate, that.reviewDate) &&
                Objects.equals(reviewId, that.reviewId) &&
                Objects.equals(goodsType, that.goodsType) &&
                Objects.equals(saleChannel, that.saleChannel) &&
                Objects.equals(unitIsShow, that.unitIsShow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, merchantId, merchantName, productId, productName, brandId, brandName, imgUrl, orderItemType, unitId, unitName, unitPrice, salePrice, paidAmount, shareRate, totalAmount, inventoryId, quantity, realQuantity, createDate, deleteFlag, signedCode, model, size, sizeUnit, discountRate, isBlatantly, serialCode, serialName, description, canRefund, color, colorRgb, omsPriceTagCode, sku, isService, referenceItemId, reviewStatus, reviewDate, reviewId, goodsType, saleChannel, unitIsShow, packageNumber);
    }
}
