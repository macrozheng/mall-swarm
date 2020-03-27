package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * Product attribute parameters
 * Created by macro on 2018/4/26.
 */
public class PmsProductAttributeParam {
    @ApiModelProperty("Attribute Classification ID")
    @NotEmpty(message = "Attribute class cannot be empty")
    private Long productAttributeCategoryId;
    @ApiModelProperty("Attribute name")
    @NotEmpty(message = "Property Name is required")
    private String name;
    @ApiModelProperty("Attribute selection type：0->unique；1->Single choice；2->Multiple choice")
    @FlagValidator({"0","1","2"})
    private Integer selectType;
    @ApiModelProperty("Property entry method：0->manual input；1->Pick from the list")
    @FlagValidator({"0","1"})
    private Integer inputType;
    @ApiModelProperty("List of optional values，Separated by commas")
    private String inputList;

    private Integer sort;
    @ApiModelProperty("Classification and filtering style：0->ordinary；1->colour")
    @FlagValidator({"0","1"})
    private Integer filterType;
    @ApiModelProperty("Type of retrieval；0->No retrieval required；1->Keyword search；2->Range search")
    @FlagValidator({"0","1","2"})
    private Integer searchType;
    @ApiModelProperty("Whether products with the same attributes are related；0->Not related；1->Related")
    @FlagValidator({"0","1"})
    private Integer relatedStatus;
    @ApiModelProperty("Whether to support manual addition；0->not support；1->Support")
    @FlagValidator({"0","1"})
    private Integer handAddStatus;
    @ApiModelProperty("Type of attribute；0->specification；1->parameter")
    @FlagValidator({"0","1"})
    private Integer type;

    public Long getProductAttributeCategoryId() {
        return productAttributeCategoryId;
    }

    public void setProductAttributeCategoryId(Long productAttributeCategoryId) {
        this.productAttributeCategoryId = productAttributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSelectType() {
        return selectType;
    }

    public void setSelectType(Integer selectType) {
        this.selectType = selectType;
    }

    public Integer getInputType() {
        return inputType;
    }

    public void setInputType(Integer inputType) {
        this.inputType = inputType;
    }

    public String getInputList() {
        return inputList;
    }

    public void setInputList(String inputList) {
        this.inputList = inputList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFilterType() {
        return filterType;
    }

    public void setFilterType(Integer filterType) {
        this.filterType = filterType;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public Integer getRelatedStatus() {
        return relatedStatus;
    }

    public void setRelatedStatus(Integer relatedStatus) {
        this.relatedStatus = relatedStatus;
    }

    public Integer getHandAddStatus() {
        return handAddStatus;
    }

    public void setHandAddStatus(Integer handAddStatus) {
        this.handAddStatus = handAddStatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
