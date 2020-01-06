package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Order shipping parameters
 * Created by macro on 2018/10/12.
 */
@Getter
@Setter
public class OmsOrderDeliveryParam {
    @ApiModelProperty("Order_id")
    private Long orderId;
    @ApiModelProperty("deliveryCompany")
    private String deliveryCompany;
    @ApiModelProperty("deliverySerialNumber")
    private String deliverySn;
}
