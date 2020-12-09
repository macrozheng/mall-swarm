package com.macro.mall.dao;

import com.macro.mall.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Custom product SKU management Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsSkuStockDao {
    /**
     * Bulk insert operation
     */
    int insertList(@Param("list")List<PmsSkuStock> skuStockList);

    /**
     * Bulk insert or replace operation
     */
    int replaceList(@Param("list")List<PmsSkuStock> skuStockList);
}
