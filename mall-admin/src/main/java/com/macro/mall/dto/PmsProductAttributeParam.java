package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * Product attribute parameters
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductAttributeParam {
    @NotEmpty
    @ApiModelProperty("Attribute category ID")
    private Long productAttributeCategoryId;
    @NotEmpty
    @ApiModelProperty("Attribute name")
    private String name;
    @FlagValidator({"0","1","2"})
    @ApiModelProperty("Attribute selection type: 0->only; 1->single selection; 2->multiple selection")
    private Integer selectType;
    @FlagValidator({"0","1"})
    @ApiModelProperty("Attribute entry method: 0->manual entry; 1->select from the list")
    private Integer inputType;
    @ApiModelProperty("A list of optional values, separated by commas")
    private String inputList;

    private Integer sort;
    @FlagValidator({"0","1"})
    @ApiModelProperty("Category filter style: 0->common; 1->color")
    private Integer filterType;
    @FlagValidator({"0","1","2"})
    @ApiModelProperty("Search type; 0->no need to search; 1->keyword search; 2->range search")
    private Integer searchType;
    @FlagValidator({"0","1"})
    @ApiModelProperty("Whether products with the same attribute are related; 0->not related; 1->related")
    private Integer relatedStatus;
    @FlagValidator({"0","1"})
    @ApiModelProperty("Whether to support manual addition; 0->not supported; 1->support")
    private Integer handAddStatus;
    @FlagValidator({"0","1"})
    @ApiModelProperty("Type of attribute; 0->specification; 1->parameter")
    private Integer type;
}
