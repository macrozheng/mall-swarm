package com.macro.mall.dto;

import com.macro.mall.model.SmsCoupon;
import com.macro.mall.model.SmsCouponProductCategoryRelation;
import com.macro.mall.model.SmsCouponProductRelation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Coupon information package, including bound goods and bound categories
 * Created by macro on 2018/8/28.
 */
public class SmsCouponParam extends SmsCoupon {
    @Getter
    @Setter
    @ApiModelProperty("Coupon product Relation products")
    private List<SmsCouponProductRelation> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("Product categories related to coupons")
    private List<SmsCouponProductCategoryRelation> productCategoryRelationList;
}
