package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Query the results returned when a single product is modified
 * Created by macro on 2018/4/26.
 */
public class PmsProductResult extends PmsProductParam {
    @Getter
    @Setter
    @ApiModelProperty("Parent id of the selected category")
    private Long cateParentId;
}
