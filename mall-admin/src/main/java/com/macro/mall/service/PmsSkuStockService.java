package com.macro.mall.service;

import com.macro.mall.model.PmsSkuStock;

import java.util.List;

/**
 * SKU product inventory managementService
 * Created by macro on 2018/4/27.
 */
public interface PmsSkuStockService {
    /**
     * Fuzzy search based on Product id and SKU Code
     */
    List<PmsSkuStock> getList(Long pid, String keyword);

    /**
     * Bulk Update product inventory information
     */
    int update(Long pid, List<PmsSkuStock> skuStockList);
}
