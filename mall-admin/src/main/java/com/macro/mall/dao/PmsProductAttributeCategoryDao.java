package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * Custom Product Attribute Classification Dao
 * Created by macro on 2018/5/24.
 */
public interface PmsProductAttributeCategoryDao {
    /**
     * Get product attribute classification, including attributes
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
