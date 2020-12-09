package com.macro.mall.dto;

import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.model.OmsOrderOperateHistory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Order details
 * Created by macro on 2018/10/11.
 */
public class OmsOrderDetail extends OmsOrder {
    @Getter
    @Setter
    @ApiModelProperty("Order item list")
    private List<OmsOrderItem> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("Order operation History list")
    private List<OmsOrderOperateHistory> historyList;
}
