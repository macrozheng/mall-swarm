package com.macro.mall.dto;

import com.macro.mall.model.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Parameter used when creating and modifying offers
 * Created by macro on 2018/4/26.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsProductParam extends PmsProduct{
    @ApiModelProperty("Product Ladder Price Settings")
    private List<PmsProductLadder> productLadderList;
    @ApiModelProperty("Product full price reduction setting")
    private List<PmsProductFullReduction> productFullReductionList;
    @ApiModelProperty("Product member price setting")
    private List<PmsMemberPrice> memberPriceList;
    @ApiModelProperty("Product SKU inventory information")
    private List<PmsSkuStock> skuStockList;
    @ApiModelProperty("Product parameter and custom specification attributes")
    private List<PmsProductAttributeValue> productAttributeValueList;
    @ApiModelProperty("Special Topics and Product Relations")
    private List<CmsSubjectProductRelation> subjectProductRelationList;
    @ApiModelProperty("Relationship between preferred area and Product")
    private List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList;
}
