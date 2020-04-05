package com.macro.mall.dao;

import com.macro.mall.dto.PmsProductCategoryWithChildrenItem;

import java.util.List;

/**
 * Product Category Custom Dao
 * Created by macro on 2018/5/25.
 */
public interface PmsProductCategoryDao {
    /**
     * Get product categories including subcategories
     */
    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
