package com.mo.jib.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @description:
 * @author: MoXingwang 2018-07-16 16:57
 **/
@ApiModel(value = "Order", description = "订单实体")
public class Order {
    @ApiModelProperty(value = "订单id")
    private String id;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "店铺名称")
    private String shopName;

    public Order(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
