package com.macro.mall.dto;

import com.macro.mall.validator.FlagValidator;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

/**
 * 商品属性参数
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductAttributeParam {
    @NotEmpty
    @ApiModelProperty("属性分类ID")
    private Long productAttributeCategoryId;
    @NotEmpty
    @ApiModelProperty("属性名称")
    private String name;
    @FlagValidator({"0","1","2"})
    @ApiModelProperty("属性选择类型：0->唯一；1->单选；2->多选")
    private Integer selectType;
    @FlagValidator({"0","1"})
    @ApiModelProperty("属性录入方式：0->手工录入；1->从列表中选取")
    private Integer inputType;
    @ApiModelProperty("可选值列表，以逗号隔开")
    private String inputList;

    private Integer sort;
    @FlagValidator({"0","1"})
    @ApiModelProperty("分类筛选样式：0->普通；1->颜色")
    private Integer filterType;
    @FlagValidator({"0","1","2"})
    @ApiModelProperty("检索类型；0->不需要进行检索；1->关键字检索；2->范围检索")
    private Integer searchType;
    @FlagValidator({"0","1"})
    @ApiModelProperty("相同属性产品是否关联；0->不关联；1->关联")
    private Integer relatedStatus;
    @FlagValidator({"0","1"})
    @ApiModelProperty("是否支持手动新增；0->不支持；1->支持")
    private Integer handAddStatus;
    @FlagValidator({"0","1"})
    @ApiModelProperty("属性的类型；0->规格；1->参数")
    private Integer type;
}
