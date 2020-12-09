package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Confirm receipt submission parameters
 * Created by macro on 2018/10/18.
 */
@Getter
@Setter
public class OmsUpdateStatusParam {
    @ApiModelProperty("Ticket number")
    private Long id;
    @ApiModelProperty("Shipping address association id")
    private Long companyAddressId;
    @ApiModelProperty("Confirm the refund amount")
    private BigDecimal returnAmount;
    @ApiModelProperty("Handling notes")
    private String handleNote;
    @ApiModelProperty("Handler")
    private String handleMan;
    @ApiModelProperty("Receipt note")
    private String receiveNote;
    @ApiModelProperty("Receiver")
    private String receiveMan;
    @ApiModelProperty("application status：1->Returning；2->completed；3->Rejected")
    private Integer status;
}
