package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Order query parameters
 * Created by macro on 2018/10/11.
 */
@Getter
@Setter
public class OmsOrderQueryParam {
    @ApiModelProperty(value = "Order Number")
    private String orderSn;
    @ApiModelProperty(value = "Name/number of consignee")
    private String receiverKeyword;
    @ApiModelProperty(value = "Order Status：0->Pending payment；1->to be delivered；2->Shipped；3->completed；4->closed；5->Invalid order")
    private Integer status;
    @ApiModelProperty(value = "Order Type：0->Normal order；1->Flash Order")
    private Integer orderType;
    @ApiModelProperty(value = "Order source：0->PC_order；1->app_order")
    private Integer sourceType;
    @ApiModelProperty(value = "Order submission time")
    private String createTime;
}
