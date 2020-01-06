package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Order return request query parameters
 * Created by macro on 2018/10/18.
 */
@Getter
@Setter
public class OmsReturnApplyQueryParam {
    @ApiModelProperty("Ticket number")
    private Long id;
    @ApiModelProperty(value = "Name/number of consignee")
    private String receiverKeyword;
    @ApiModelProperty(value = "application status：0->Pending；1->Returning；2->completed；3->Rejected")
    private Integer status;
    @ApiModelProperty(value = "application time")
    private String createTime;
    @ApiModelProperty(value = "Processing staff")
    private String handleMan;
    @ApiModelProperty(value = "Processing time")
    private String handleTime;
}
