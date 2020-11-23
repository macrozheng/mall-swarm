package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Add parameters to update product category
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductCategoryParam {
    @ApiModelProperty("Number of parent category")
    private Long parentId;
    @NotEmpty
    @ApiModelProperty(value = "Product category name",required = true)
    private String name;
    @ApiModelProperty("Product Unit")
    private String productUnit;
    @FlagValidator(value = {"0","1"},message = "Status can only be 0 or 1")
    @ApiModelProperty("Whether to display in the navigation bar")
    private Integer navStatus;
    @FlagValidator(value = {"0","1"},message = "Status can only be 0 or 1")
    @ApiModelProperty("Whether to display")
    private Integer showStatus;
    @Min(value = 0)
    @ApiModelProperty("Sort")
    private Integer sort;
    @ApiModelProperty("Icon")
    private String icon;
    @ApiModelProperty("Keyword")
    private String keywords;
    @ApiModelProperty("Description")
    private String description;
    @ApiModelProperty("Product-related filter attribute List")
    private List<Long> productAttributeIdList;
}
