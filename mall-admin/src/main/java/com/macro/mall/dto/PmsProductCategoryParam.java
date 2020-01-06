package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Add parameter to update product category
 * Created by macro on 2018/4/26.
 */
public class PmsProductCategoryParam {
    @ApiModelProperty("Number of parent category")
    private Long parentId;
    @ApiModelProperty(value = "Product category name",required = true)
    @NotEmpty(message = "Category Name is required")
    private String name;
    @ApiModelProperty("Classification units")
    private String productUnit;
    @ApiModelProperty("Whether to show in the navigation bar")
    @FlagValidator(value = {"0","1"},message = "Status can only be 0 or 1")
    private Integer navStatus;
    @ApiModelProperty("Whether to display")
    @FlagValidator(value = {"0","1"},message = "Status can only be 0 or 1")
    private Integer showStatus;
    @ApiModelProperty("Sort")
    @Min(value = 0,message = "Sort minimum is 0")
    private Integer sort;
    @ApiModelProperty("icon")
    private String icon;
    @ApiModelProperty("Keywords")
    private String keywords;
    @ApiModelProperty("description")
    private String description;
    @ApiModelProperty("Product-related filtering properties collection")
    private List<Long> productAttributeIdList;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getNavStatus() {
        return navStatus;
    }

    public void setNavStatus(Integer navStatus) {
        this.navStatus = navStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getProductAttributeIdList() {
        return productAttributeIdList;
    }

    public void setProductAttributeIdList(List<Long> productAttributeIdList) {
        this.productAttributeIdList = productAttributeIdList;
    }
}
