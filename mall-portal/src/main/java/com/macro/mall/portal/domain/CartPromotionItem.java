package com.macro.mall.portal.domain;

import com.macro.mall.model.OmsCartItem;

import java.math.BigDecimal;

/**
 * Created by macro on 2018/8/27.
 * Packaging of promotional information in shopping cart
 */
public class CartPromotionItem extends OmsCartItem{
    //Promotion Event information
    private String promotionMessage;
    //Amount subtracted from promotion, per item
    private BigDecimal reduceAmount;
    //Real Stock of the Product (Stock-Locking the inventory remaining)
    private Integer realStock;
    //Gift points
    private Integer integration;
    //Buy product Give growth value
    private Integer growth;
    public String getPromotionMessage() {
        return promotionMessage;
    }

    public void setPromotionMessage(String promotionMessage) {
        this.promotionMessage = promotionMessage;
    }

    public BigDecimal getReduceAmount() {
        return reduceAmount;
    }

    public void setReduceAmount(BigDecimal reduceAmount) {
        this.reduceAmount = reduceAmount;
    }

    public Integer getRealStock() {
        return realStock;
    }

    public void setRealStock(Integer realStock) {
        this.realStock = realStock;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public Integer getGrowth() {
        return growth;
    }

    public void setGrowth(Integer growth) {
        this.growth = growth;
    }
}
