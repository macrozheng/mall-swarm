package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * Brand transfer parameters
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsBrandParam {
    @NotEmpty
    @ApiModelProperty(value = "brand name",required = true)
    private String name;
    @ApiModelProperty(value = "Brand initials")
    private String firstLetter;
    @Min(value = 0)
    @ApiModelProperty(value = "Sort field")
    private Integer sort;
    @FlagValidator(value = {"0","1"}, message = "Incorrect manufacturer status")
    @ApiModelProperty(value = "Whether it is a manufacturer")
    private Integer factoryStatus;
    @FlagValidator(value = {"0","1"}, message = "Incorrect display status")
    @ApiModelProperty(value = "Whether to display")
    private Integer showStatus;
    @NotEmpty
    @ApiModelProperty(value = "Brand logo",required = true)
    private String logo;
    @ApiModelProperty(value = "Brand big picture")
    private String bigPic;
    @ApiModelProperty(value = "Brand story")
    private String brandStory;
}
