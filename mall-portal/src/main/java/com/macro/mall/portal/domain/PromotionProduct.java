package com.macro.mall.portal.domain;

import com.macro.mall.model.PmsProduct;
import com.macro.mall.model.PmsProductFullReduction;
import com.macro.mall.model.PmsProductLadder;
import com.macro.mall.model.PmsSkuStock;

import java.util.List;

/**
 * Created by macro on 2018/8/27.
 * Product promotion information, including SKU, discounts, full discounts
 */
public class PromotionProduct extends PmsProduct {
    //Product Stock Information
    private List<PmsSkuStock> skuStockList;
    //Product discount information
    private List<PmsProductLadder> productLadderList;
    //Product full reduction information
    private List<PmsProductFullReduction> productFullReductionList;

    public List<PmsSkuStock> getSkuStockList() {
        return skuStockList;
    }

    public void setSkuStockList(List<PmsSkuStock> skuStockList) {
        this.skuStockList = skuStockList;
    }

    public List<PmsProductLadder> getProductLadderList() {
        return productLadderList;
    }

    public void setProductLadderList(List<PmsProductLadder> productLadderList) {
        this.productLadderList = productLadderList;
    }

    public List<PmsProductFullReduction> getProductFullReductionList() {
        return productFullReductionList;
    }

    public void setProductFullReductionList(List<PmsProductFullReduction> productFullReductionList) {
        this.productFullReductionList = productFullReductionList;
    }
}
