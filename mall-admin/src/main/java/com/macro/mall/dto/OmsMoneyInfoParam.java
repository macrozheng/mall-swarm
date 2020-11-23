package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Modify order fee information parameters
 * Created by macro on 2018/10/29.
 */
@Getter
@Setter
public class OmsMoneyInfoParam {
    @ApiModelProperty("Order id")
    private Long orderId;
    @ApiModelProperty("Freight amount")
    private BigDecimal freightAmount;
    @ApiModelProperty("The administrator adjusts the discount amount used in the order")
    private BigDecimal discountAmount;
    @ApiModelProperty("Order status: 0->to be paid; 1->to be shipped; 2->shipped; 3->completed; 4->closed; 5->invalid order")
    private Integer status;
}
