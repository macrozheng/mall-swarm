package com.macro.mall.demo.dto;

import com.macro.mall.demo.validator.FlagValidator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Brand delivery parameters
 */
@ApiModel(value = "PmsBrandDto")
public class PmsBrandDto {
    @ApiModelProperty(value = "brand name",required = true)
    @NotNull(message = "A Name is required")
    private String name;
    @ApiModelProperty(value = "Brand initials",required = true)
    @NotNull(message = "The first letter cannot be empty")
    private String firstLetter;
    @ApiModelProperty(value = "Sort fields")
    @Min(value = 0, message = "Sort minimum is 0")
    private Integer sort;
    @ApiModelProperty(value = "Is it a manufacturer?")
    @FlagValidator(value = {"0","1"}, message = "Manufacturer status is incorrect")
    private Integer factoryStatus;
    @ApiModelProperty(value = "Whether to display")
    @FlagValidator(value = {"0","1"}, message = "The display status is incorrect")
    private Integer showStatus;
    @ApiModelProperty(value = "Brand logo")
    private String logo;
    @ApiModelProperty(value = "Brand big picture")
    private String bigPic;
    @ApiModelProperty(value = "Brand story")
    private String brandStory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(Integer factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }
}
