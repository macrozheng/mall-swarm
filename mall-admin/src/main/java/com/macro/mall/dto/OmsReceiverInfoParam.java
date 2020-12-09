package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Order Modify consignee information parameters
 * Created by macro on 2018/10/29.
 */
@Getter
@Setter
public class OmsReceiverInfoParam {
    @ApiModelProperty(value = "Order id")
    private Long orderId;
    @ApiModelProperty(value = "Receiver name")
    private String receiverName;
    @ApiModelProperty(value = "Receiver phone")
    private String receiverPhone;
    @ApiModelProperty(value = "Zip code of receiver")
    private String receiverPostCode;
    @ApiModelProperty(value = "Address")
    private String receiverDetailAddress;
    @ApiModelProperty(value = "Province/City")
    private String receiverProvince;
    @ApiModelProperty(value = "City")
    private String receiverCity;
    @ApiModelProperty(value = "Region")
    private String receiverRegion;
    @ApiModelProperty(value = "Order status: 0->to be paid; 1->to be shipped; 2->shipped; 3->completed; 4->closed; 5->invalid order")
    private Integer status;
}
