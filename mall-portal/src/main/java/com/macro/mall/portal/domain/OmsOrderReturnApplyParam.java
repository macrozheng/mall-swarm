package com.macro.mall.portal.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 申请退货parameter
 * Created by macro on 2018/10/17.
 */
@Getter
@Setter
public class OmsOrderReturnApplyParam {
    @ApiModelProperty("Order_id")
    private Long orderId;
    @ApiModelProperty("Returned product id")
    private Long productId;
    @ApiModelProperty("Order Number")
    private String orderSn;
    @ApiModelProperty("Member username")
    private String memberUsername;
    @ApiModelProperty("Name of returner")
    private String returnName;
    @ApiModelProperty("Returner Phone")
    private String returnPhone;
    @ApiModelProperty("Product picture")
    private String productPic;
    @ApiModelProperty("product name")
    private String productName;
    @ApiModelProperty("Product brand")
    private String productBrand;
    @ApiModelProperty("Product Sales Attributes：colour：Red；size：xl;")
    private String productAttr;
    @ApiModelProperty("Number of returns")
    private Integer productCount;
    @ApiModelProperty("Product price")
    private BigDecimal productPrice;
    @ApiModelProperty("The actual unit price of the product")
    private BigDecimal productRealPrice;
    @ApiModelProperty("The reason")
    private String reason;
    @ApiModelProperty("description")
    private String description;
    @ApiModelProperty("Voucher picture，Separated by commas")
    private String proofPics;

}
