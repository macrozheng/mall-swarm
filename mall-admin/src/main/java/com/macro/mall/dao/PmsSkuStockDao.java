package com.macro.mall.dao;

import com.macro.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom product SKU inventory Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsSkuStockDao {
    /**
     * Bulk insertion operations
     */
    int insertList(@Param("list")List<PmsSkuStock> skuStockList);

    /**
     * Bulk insert or replace operations
     */
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);
}
