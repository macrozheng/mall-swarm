package com.macro.mall.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Product category corresponding attribute information
 * Created by macro on 2018/5/23.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductAttrInfo {
    @ApiModelProperty("Product attribute ID")
    private Long attributeId;
    @ApiModelProperty("Product attribute category ID")
    private Long attributeCategoryId;
}
