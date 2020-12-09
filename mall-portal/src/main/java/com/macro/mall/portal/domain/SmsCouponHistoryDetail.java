package com.macro.mall.portal.domain;

import com.macro.mall.model.SmsCoupon;
import com.macro.mall.model.SmsCouponHistory;
import com.macro.mall.model.SmsCouponProductCategoryRelation;
import com.macro.mall.model.SmsCouponProductRelation;

import java.util.List;

/**
 * Coupon collection history details package
 * Created by macro on 2018/8/29.
 */
public class SmsCouponHistoryDetail extends SmsCouponHistory {
    //Related Coupon Information
    private SmsCoupon coupon;
    //Coupons Related Products
    private List<SmsCouponProductRelation> productRelationList;
    //Coupons RelatedProduct Categories
    private List<SmsCouponProductCategoryRelation> categoryRelationList;

    public SmsCoupon getCoupon() {
        return coupon;
    }

    public void setCoupon(SmsCoupon coupon) {
        this.coupon = coupon;
    }

    public List<SmsCouponProductRelation> getProductRelationList() {
        return productRelationList;
    }

    public void setProductRelationList(List<SmsCouponProductRelation> productRelationList) {
        this.productRelationList = productRelationList;
    }

    public List<SmsCouponProductCategoryRelation> getCategoryRelationList() {
        return categoryRelationList;
    }

    public void setCategoryRelationList(List<SmsCouponProductCategoryRelation> categoryRelationList) {
        this.categoryRelationList = categoryRelationList;
    }
}
