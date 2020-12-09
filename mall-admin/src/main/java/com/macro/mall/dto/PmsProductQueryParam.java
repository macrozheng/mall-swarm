package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Product query parameter
 * Created by macro on 2018/4/27.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductQueryParam {
    @ApiModelProperty("Up-shelf status")
    private Integer publishStatus;
    @ApiModelProperty("Approval Status")
    private Integer verifyStatus;
    @ApiModelProperty("Product Name Fuzzy Keywords")
    private String keyword;
    @ApiModelProperty("Product Code")
    private String productSn;
    @ApiModelProperty("Product Classification Number")
    private Long productCategoryId;
    @ApiModelProperty("Product Brand Number")
    private Long brandId;
}
