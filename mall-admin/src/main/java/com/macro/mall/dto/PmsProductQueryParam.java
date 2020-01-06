package com.macro.mall.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Product query parameter
 * Created by macro on 2018/4/27.
 */
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

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getProductSn() {
        return productSn;
    }

    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}
